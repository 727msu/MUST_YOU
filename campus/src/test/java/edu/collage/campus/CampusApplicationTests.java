package edu.collage.campus;

import edu.collage.campus.controller.UserController;
import edu.collage.campus.entity.booking;
import edu.collage.campus.service.impl.activityServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

@SpringBootTest
class CampusApplicationTests {

    @Autowired
    UserController userController;

    @Autowired
    activityServiceImpl activityService;
    @Test
    void contextLoads() {
    }

    @Test
    void co() {
        booking booking = new booking(55655654151515515L, 5656262623261561121L, LocalTime.MIDNIGHT, LocalTime.now(), LocalDate.now(), 1);
        String string = userController.QRCodeToString(userController.generateQRCode(booking.toString()));
        System.out.println("string len base64" + string.length() + "\n" + string);
    }

    @Test
    void oo(){
        LocalDate localDate = LocalDate.parse("2024-12-12");
        System.out.println("localDate = " + localDate);
        String phoneRegex = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
        String passRegex = "^[a-zA-Z0-9]{4,16}$";
        if (!Pattern.matches(phoneRegex, "15384633623")) {
            // 手机号格式不正确，注册失败
            System.out.println("验证不通过");
            return;
        }

        System.out.println("验证通过");
    }
    @Test
    void ccc(){
        System.out.println(activityService.list());
    }

}
