package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHello(){
        return "hello";
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/showRegisterPage")
    public String showRegisterPage(){
        return "register";
    }

    @GetMapping("/leaders")
    public String showEmployeePage(){
        return "employee";
    }

    @GetMapping("/admin")
    public String showAdminPage(){
        return "admin";
    }

    @GetMapping("/accessDenied")
    public String showDeniedPage(){
        return "accessDenied";
    }


}
