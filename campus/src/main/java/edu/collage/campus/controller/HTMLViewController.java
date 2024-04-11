package edu.collage.campus.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class HTMLViewController {


    @RequestMapping("/login")
    public String LoginView() {
        return "Login";
    }

    @RequestMapping("/register")
    public String RegisterView(@RequestParam(required = false) String error, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (error != null) {
            response.getWriter().write("<script>window.onload = function (){my_alert('error', " + error + ")}</script>");
        }
        return "Register";
    }
}
