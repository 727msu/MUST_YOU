package edu.collage.campus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.collage.campus.entity.OrderDetailsView;
import edu.collage.campus.entity.activity;
import edu.collage.campus.entity.booking;
import edu.collage.campus.entity.users;
import edu.collage.campus.util.RestResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import edu.collage.campus.service.usersService;
import edu.collage.campus.service.activityService;
import edu.collage.campus.service.activityImagesService;
import edu.collage.campus.service.authoritiesService;
import edu.collage.campus.service.bookingService;
import edu.collage.campus.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
    @RequestMapping("/crud")
public class CRUDController {
    final usersService usersService;
    final activityService activityService;
    final activityImagesService activityImagesService;
    final authoritiesService authoritiesService;
    final bookingService bookingService;
    final OrderService orderService;

    public CRUDController(usersService usersService, activityService activityService, activityImagesService activityImagesService, authoritiesService authoritiesService, bookingService bookingService, OrderService orderService) {
        this.usersService = usersService;
        this.activityService = activityService;
        this.activityImagesService = activityImagesService;
        this.authoritiesService = authoritiesService;
        this.bookingService = bookingService;
        this.orderService = orderService;
    }


    // ======================            用户表CRUD                  ===============================

    @GetMapping("/user/{userId}")
    public List<users> getUsersList(@PathVariable Long userId) {
        if (userId == null) {
            //得到全部用户数据
            return usersService.list();
        }
        //得到指定用户数据
        QueryWrapper<users> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userId);
        return usersService.list(wrapper);
    }

    @PostMapping("/user")
    public RestResult addUser(@RequestBody users users) {
        boolean saved = usersService.save(users);
        if (!saved) {
            return RestResult.failed("添加用户失败");
        }
        return RestResult.succeed("添加用户成功");
    }

    @PutMapping("/user/{userId}")
    public RestResult updateUser(@PathVariable Long userId, @RequestBody users users) {

        QueryWrapper<users> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userId);
        boolean update = usersService.update(users, wrapper);
        if (!update) {
            return RestResult.failed("修改用户数据失败");
        }
        return RestResult.succeed("修改用户数据成功");

    }

    @DeleteMapping("/user/{userId}")
    public RestResult delUser(@PathVariable Long userId, @RequestBody users users) {
        QueryWrapper<users> wrapper = new QueryWrapper<>();

        // 日志记录
        users one = usersService.getOne(wrapper);
        log.warn("{}: 删除了用户数据 {}", LocalDateTime.now(), one);


        wrapper.eq("id", userId);
        boolean remove = usersService.remove(wrapper);
        if (!remove) {
            return RestResult.failed("删除用户数据失败");
        }
        return RestResult.succeed("删除用户数据成功");
    }


    // ======================            活动表CRUD                  ===============================

    @GetMapping("/activity/{activityId}")
    public List<activity> getActivityList(@PathVariable Long activityId) {
        if (activityId == null || activityId == -1) {
            //得到全部活动数据
            return activityService.getList(new QueryWrapper<>());
        }
        //得到指定活动数据
        QueryWrapper<activity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", activityId);
        return activityService.getList(wrapper);
    }

    @PostMapping("/activity")
    public RestResult addActivity(@RequestBody activity activity) {
        boolean saved = activityService.save(activity);
        if (!saved) {
            return RestResult.failed("添加活动失败");
        }
        return RestResult.succeed("添加活动成功");
    }

    @PutMapping("/activity/{activityId}")
    public RestResult updateActivity(@PathVariable Long activityId, @RequestBody activity activity) {

        QueryWrapper<activity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", activityId);
        boolean update = activityService.update(activity, wrapper);
        if (!update) {
            return RestResult.failed("修改活动数据失败");
        }
        return RestResult.succeed("修改活动数据成功");

    }

    @DeleteMapping("/activity/{activityId}")
    public RestResult delActivity(@PathVariable Long activityId, @RequestBody activity activity) {
        QueryWrapper<activity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", activityId);

        // 日志记录
        activity one = activityService.getOne(wrapper);
        log.warn("{}: 删除了活动数据 {}", LocalDateTime.now(), one);


        boolean remove = activityService.remove(wrapper);
        if (!remove) {
            return RestResult.failed("删除活动数据失败");
        }
        return RestResult.succeed("删除活动数据成功");
    }


    // ======================            订单表CRUD                  ===============================

    @GetMapping("/order/{orderId}")
    public List<OrderDetailsView> getOrderDetailsList(@PathVariable Long orderId) {
        if (orderId == null) {
            //得到全部用户数据
            return orderService.list();
        }
        //得到指定用户数据
        QueryWrapper<OrderDetailsView> wrapper = new QueryWrapper<>();
        wrapper.eq("id", orderId);
        return orderService.list(wrapper);
    }

    @PostMapping("/order")
    public RestResult addOrder(@RequestBody OrderDetailsView order) {
        boolean saved = orderService.save(order);
        if (!saved) {
            return RestResult.failed("添加订单失败");
        }
        return RestResult.succeed("添加订单成功");
    }

    @PutMapping("/order/{orderId}")
    public RestResult updateOrder(@PathVariable Long orderId, @RequestBody OrderDetailsView order) {
        QueryWrapper<OrderDetailsView> wrapper = new QueryWrapper<>();
        wrapper.eq("id", orderId);
        boolean update = orderService.update(order, wrapper);
        if (!update) {
            return RestResult.failed("修改订单数据失败");
        }
        return RestResult.succeed("修改订单数据成功");

    }

    @DeleteMapping("/order/{orderId}")
    public RestResult delOrder(@PathVariable Long orderId) {
        QueryWrapper<OrderDetailsView> wrapper = new QueryWrapper<>();
        wrapper.eq("id", orderId);

        // 日志记录
        OrderDetailsView one = orderService.getOne(wrapper);
        log.warn("{}: 删除了订单数据 {}", LocalDateTime.now(), one);


        boolean remove = orderService.remove(wrapper);
        if (!remove) {
            return RestResult.failed("删除订单数据失败");
        }
        return RestResult.succeed("删除订单数据成功");
    }


    //======================            预约入校表CRUD                  ===============================

    @GetMapping("/booking/{bookingId}")
    public List<booking> getBookingDetailsList(@PathVariable Long bookingId) {
        if (bookingId == null) {
            //得到全部用户数据
            return bookingService.list();
        }
        //得到指定用户数据
        QueryWrapper<booking> wrapper = new QueryWrapper<>();
        wrapper.eq("id", bookingId);
        return bookingService.list(wrapper);
    }

    @PostMapping("/booking")
    public RestResult addBooking(@RequestBody booking booking) {
        boolean saved = bookingService.save(booking);
        if (!saved) {
            return RestResult.failed("添加入校预约失败");
        }
        return RestResult.succeed("添加入校预约成功");
    }

    @PutMapping("/booking/{bookingId}")
    public RestResult updateActivity(@PathVariable Long bookingId, @RequestBody booking booking) {
        QueryWrapper<booking> wrapper = new QueryWrapper<>();
        wrapper.eq("id", bookingId);
        boolean update = bookingService.update(booking, wrapper);
        if (!update) {
            return RestResult.failed("修改入校预约数据失败");
        }
        return RestResult.succeed("修改入校预约数据成功");

    }


    @DeleteMapping("/booking/{bookingId}")
    public RestResult delBooking(@PathVariable Long bookingId) {
        QueryWrapper<booking> wrapper = new QueryWrapper<>();
        wrapper.eq("id", bookingId);

        // 日志记录
        booking one = bookingService.getOne(wrapper);
        log.warn("{}: 删除了入校预约数据 {}", LocalDateTime.now(), one);


        boolean remove = bookingService.remove(wrapper);
        if (!remove) {
            return RestResult.failed("删除入校预约数据失败");
        }
        return RestResult.succeed("删除入校预约数据成功");
    }


}
