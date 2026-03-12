package com.example.sd20308.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String index() {
        return "login.html";
    }

    @GetMapping("/index")
    public String index2(Model model) {
        String name = "Lê Quang Minh";
        String lop = "SD20308";
        Integer tuoi = 17;
        model.addAttribute("name", name);
        model.addAttribute("lop", lop);
        model.addAttribute("tuoi", tuoi);
        return "index.html";
    }
}
