package com.example.sd20308.controller;


import com.example.sd20308.model.User;
import com.example.sd20308.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

//    @GetMapping("/login")
//    public String index() {
//        return "login.html";
//    }

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


    @PostMapping("/search")
    public String search(Model model, @RequestParam("phone") String phone) {
//        User result = new User();
//        for (User u : users) {
//            if (u.getPhone().equals(phone)) {
//                result = u;
//            }
//        }
//        model.addAttribute("user", result);
        return "user-detail.html";

    }

    @Autowired
    UserRepo userRepo;

    @GetMapping("/list-user")
    public String listUser(Model model) {

        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "index.html";
    }

    @PostMapping("/save")
    public String save(
            User user
    ) {
        userRepo.save(user);
        return "redirect:/list-user";
    }

    @GetMapping("/detail")
    public String detail(Model model) {
        return "user-detail.html";
    }

    @GetMapping("/delete")
    public String delete(
            @RequestParam("id") Integer id
    ) {
        userRepo.deleteById(id);
        return "redirect:/list-user";
    }


}
