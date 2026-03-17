package com.example.sd20308.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login-form")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping("/login")
    public void login(
            @RequestParam("username") String userName
    ) {
        System.out.println("ban vua nhap: " + userName);
    }
}
