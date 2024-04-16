package edu.collage.campus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import edu.collage.campus.entity.*;
import edu.collage.campus.service.*;
import edu.collage.campus.util.QRCodeResult;
import edu.collage.campus.util.RestResult;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/auth")
@Log4j2
public class UserController {
    final usersService usersService;
    final bookingService bookingService;
    final activityService activityService;

    final edu.collage.campus.service.activityImagesService activityImagesService;

    final authoritiesService authoritiesService;

    final Users_forActivityService usersActivityService;

    final OrderService orderService;


    public UserController(usersService usersService, bookingService bookingService, activityService activityService, edu.collage.campus.service.activityImagesService activityImagesService, authoritiesService authoritiesService, Users_forActivityService usersActivityService, OrderService orderService) {
        this.usersService = usersService;
        this.bookingService = bookingService;
        this.activityService = activityService;
        this.activityImagesService = activityImagesService;
        this.authoritiesService = authoritiesService;
        this.usersActivityService = usersActivityService;
        this.orderService = orderService;


    }

    /**
     * @param username
     * @param password
     * @param request
     * @param response
     * @return index.html
     * @throws IOException
     * @desc 用户登录接口
     */
    @PostMapping("/login")
    @ResponseBody
    public RestResult userLogin(@RequestParam(required = false) String username, @RequestParam(required = false) String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (username == null || password == null) {
//            response.getWriter().write("<script>window.onload = function() { tw_alert('登录失败,参数为空',false); }</script>");
//            return "Login";
            return RestResult.failed("登录失败,参数为空");
        }
        QueryWrapper<users> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(wrapper -> wrapper.eq("username", username).or().eq("phone", username));
        queryWrapper.eq("password", password);


        users user = usersService.getOne(queryWrapper);
        if (user == null) {
//            response.getWriter().write("<script>window.onload = function() { tw_alert('登录失败,用户不存在',false); }</script>");
//            return "Login";
            return RestResult.failed("登录失败,用户不存在");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        Cookie cookie1 = new Cookie("lang", "CN-zh");
        cookie1.setMaxAge(259200);

        response.addCookie(cookie1);
//        return "redirect:/";
        return new RestResult<>("succeed", 200200, user);
    }

    /**
     * @param username
     * @param password
     * @param organization
     * @param request
     * @return index.html
     * @desc 用户注册接口
     */
    @PostMapping("/register")
    @ResponseBody
    public RestResult userRegister(@RequestParam String username, @RequestParam String password, @RequestParam String organization, HttpServletRequest request) {
        String phoneRegex = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
        String passRegex = "^[a-zA-Z0-9]{4,16}$";
        if (!Pattern.matches(phoneRegex, username)) {
            // 手机号格式不正确，注册失败
//            return "redirect:/register?error=invalid_phone";
            return RestResult.failed("invalid_phone");
        }
        if (!Pattern.matches(passRegex, password)) {
            // 密码格式不正确，注册失败
//            return "redirect:/register?error=invalid_password";
            return RestResult.failed("invalid_password");
        }
        if (!organization.equals("校内人员") && !organization.equals("校外人员")) {
            // 组织格式不正确，注册失败
//            return "redirect:/register?error=invalid_organization";
            return RestResult.failed("invalid_organization");
        }

        QueryWrapper<users> wrapper = new QueryWrapper<users>().eq("phone", username);

        users existingUser = usersService.getOne(wrapper);

        if (existingUser != null) {

            //用户已注册/存在
//            return "redirect:/register?error=user_exist";
            return RestResult.failed("user_exist");
        }

        users user = new users(null, null, username, password, organization, true);
        boolean save = usersService.save(user);
        if (!save) {
            //注册失败 (数据库连接错误/数据库内部错误)
//            return "redirect:/register?error=server_error";
            return RestResult.failed("server_error");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return new RestResult<>("登录成功", 200200, user);
    }

    /**
     * @param data
     * @return blob
     * @desc 验证码生成服务
     */
    @PostMapping("/generateQRcode")
    public ResponseEntity<byte[]> generateQRCode_(String data) {
        if (data == null) new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        try {
            byte[] imageBytes = generateQRCode(data);
            // 设置 HTTP 响应头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentLength(imageBytes.length);
            // 返回图片数据
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public byte[] generateQRCode(String data) {
        if (data == null) return null;
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hint = new HashMap<>();
            hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hint.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 220, 220, hint);

            // 调整图像大小以留白边距
            int qrWidth = bitMatrix.getWidth();
            int qrHeight = bitMatrix.getHeight();

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            // 将图片转换为 byte 数组
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            // 返回图片数据
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String QRCodeToString(byte[] bytes) {
        if (bytes == null) return null;
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * @param qrCodeData
     * @return
     * @desc 二维码校验服务
     */
    @GetMapping("/validateQRCode")
    @ResponseBody
    public QRCodeResult<String> validateQRCode(@RequestParam String qrCodeData) {
        // 验证解码后的内容是否符合规范
        if (isValidQRCodeData(qrCodeData)) {
            return QRCodeResult.succeed();
        }
        return QRCodeResult.failed();
    }

    private boolean isValidQRCodeData(String qrCodeData) {
        // 在这里添加对二维码数据的规范验证逻辑
        // 返回 true 如果数据符合规范，否则返回 false
        // 以下是一个示例，你需要根据实际情况进行验证
        return qrCodeData.matches("^\\d{6}$"); // 假设数据必须是 6 位数字
    }

    /**
     * @param userid
     * @param starTime
     * @param endTime
     * @param date
     * @param request
     * @return JSON
     * @desc 预约入校
     */
    @PostMapping("/booking/{userid}")
    @ResponseBody
    public RestResult booking(@PathVariable Long userid, @RequestParam LocalTime starTime, @RequestParam LocalTime endTime, @RequestParam LocalDate date, HttpServletRequest request) {
        HttpSession session = request.getSession();
        users users = (users) session.getAttribute("user");
        // 参数校验
        if (userid == null || starTime == null || endTime == null || date == null || !starTime.isBefore(endTime) || !date.isAfter(LocalDate.now())) {
            return RestResult.failed("参数错误");
        }
        // 未登录
        if (users == null) {
            return RestResult.failed("请先登录");
        }
        // 如果用户不是自己或者时间已经过了
        System.out.println(userid + "\t" + "users = " + users);
//        if (!userid.equals(users.getId()) || LocalDateTime.of(date, starTime).isAfter(LocalDateTime.now())) {
//            return RestResult.error("非法请求");
//        }

        //判断用户是否已经预约
        QueryWrapper<booking> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userid);
        wrapper.eq("start_time",starTime);
        wrapper.eq("end_time",endTime);
        wrapper.eq("date",date);
        booking one = bookingService.getOne(wrapper);
        System.out.println(one+"是否存在");
        if (one!=null){
            return RestResult.failed("预约失败,当前时间已经预约");
        }

        int timeSlot = bookingService.checkTimeSlot(starTime, endTime);
        LocalTime[] currentTimeSlot = bookingService.getCurrentTimeSlotNumber(timeSlot);

        booking entity = new booking(null, userid, currentTimeSlot[0], currentTimeSlot[1], date, timeSlot + 1);
        //生成QRCode
        String string = QRCodeToString(generateQRCode(entity.toString()));
        entity.setQrCode("data:image/png;base64," + string);

        boolean saved = bookingService.save(entity);
        if (!saved) {
            return RestResult.failed("请求失败");
        }
        Map<String, String> map = new HashMap<>();
        map.put("imageBase64", entity.getQrCode());
        return new RestResult<Object>("成功预约", 200200, map);
    }


    /**
     * @param userid
     * @param activityId
     * @param date
     * @param request
     * @return
     * @dec 活动预约
     */
    @PostMapping("/activity/{userid}")
    @ResponseBody
    public RestResult activityAppoint(@PathVariable Long userid, @RequestParam Long activityId, @RequestParam LocalDate date, HttpServletRequest request) {
        HttpSession session = request.getSession();
        users users = (users) session.getAttribute("user");

        if (userid == null || activityId == null) {
            return RestResult.failed("参数错误");
        }
        // 未登录或用户不是自己
        if (users == null || !userid.equals(users.getId())) {
            return RestResult.failed("请先登录");
        }
        //预约活动前检验用户是预约入校
        QueryWrapper<booking> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userid).eq("date", date);
        List<booking> booking = bookingService.list(queryWrapper);
        if (booking == null|| booking.isEmpty()) {
            return RestResult.failed("须先预约入校，方可预约活动，否则预约视为无效");
        }

        //判断同一日期内是否多次预约
        QueryWrapper<Users_forActivity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userid).eq("activity_id", activityId).eq("date", date);
        Users_forActivity one = usersActivityService.getOne(wrapper);
        if (one != null) {
            return RestResult.failed("该日期此次活动已经预约");
        }


        Users_forActivity entity = new Users_forActivity(null, userid, activityId, date);

        //生成QRCode
        String string = QRCodeToString(generateQRCode(entity.toString()));
        entity.setQrcode("data:image/png;base64," + string);

        boolean saved = usersActivityService.save(entity);

        if (!saved) return RestResult.failed("预定失败");
        Map<String, String> map = new HashMap<>();
        map.put("imageBase64", entity.getQrcode());
        return new RestResult<Object>("活动预约成功", 200200, map);
    }

    /**
     * @param userId   用户id
     * @param date     查询日期 格式yyyy-mm-dd  c:1920-04-10 e:1920-4-25 is mistake
     * @param username 用户名
     * @param phone    手机号
     * @param request  请求体
     * @return {@link OrderDetailsView}
     * @desc 获取用户订单数据
     */
    @GetMapping("/getUserOrder/{userId}")
    @ResponseBody
    public RestResult getUserOrder(@PathVariable Long userId, @RequestParam(required = false) LocalDate date, @RequestParam(required = false) String username, @RequestParam(required = false) String phone, HttpServletRequest request) {

        HttpSession session = request.getSession();
        users user1 = (users) session.getAttribute("user");
//        if (user1 == null || userId.equals(user1.getId())) {
//            return RestResult.failed("用户不匹配");
//        }

        QueryWrapper<users> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userId);
        users user = usersService.getOne(wrapper);
        if (username == null) {
            username = user.getUsername();
        }
        if (phone == null) {
            phone = user.getPhone();
        }
        List<OrderDetailsView> forOpt = orderService.getUserOrder(date, username, phone);
        return new RestResult<>("succeed", 200200, forOpt);
    }


    /**
     * @param date
     * @return
     * @desc 指定日期 不同时间段的人数
     */
    @GetMapping("/getGroup")
    @ResponseBody
    public RestResult getGroup(@RequestParam LocalDate date) {
        return new RestResult<>("succeed", 200200, bookingService.getGroupForNumber(date));
    }

    /**
     * @param date
     * @param username
     * @param phone
     * @return {@link OrderDetailJSONObj}
     * @desc 请求用户订单详情
     */
    @GetMapping("/getUserOrderDetail")
    @ResponseBody
    public RestResult getUserOrderDetail(@RequestParam LocalDate date, @RequestParam(required = false) String username, @RequestParam(required = false) String phone) {
        if (username == null && phone == null) {
            return RestResult.failed("参数缺失");
        }
        return new RestResult<>("succeed", 200200, orderService.getUserOrderDetailForJSON(date, username, phone));
    }


    @GetMapping("/getActivityQRCode")
    @ResponseBody
    public RestResult getActivityQRCode(@RequestParam Long usersId, @RequestParam Long activityId, @RequestParam LocalDate date) {
        QueryWrapper<Users_forActivity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", usersId);
        wrapper.eq("activity_id", activityId);
        wrapper.eq("date", date);
        Users_forActivity one = usersActivityService.getOne(wrapper);
        if (one == null) return RestResult.failed("查询失败");
        return new RestResult<>("succeed", 200200, one);
    }
}
