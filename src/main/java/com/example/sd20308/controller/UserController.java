package com.example.sd20308.controller;


import com.example.sd20308.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

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

    @GetMapping("/list-user")
    public String listUser(Model model) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "nguyenvv4@fpt.edu.vn", "0987654321", "Vu Van Nguyen", "123456", true, true));
        users.add(new User(2, "nguyenvv5@fpt.edu.vn", "0987654321", "Tran Tuan Phong", "123456", true, false));
        users.add(new User(3, "nguyenvv6@fpt.edu.vn", "0987654321", "Nguyen Hoang Tien", "123456", false, true));
        users.add(new User(4, "nguyenvv7@fpt.edu.vn", "0987654321", "Nguyen Anh Dung", "123456", true, false));
        users.add(new User(5, "nguyenvv8@fpt.edu.vn", "0987654321", "NGuyen Quang Ha", "123456", false, true));
        // truyen danh sach user cho UI
        model.addAttribute("users", users);
        return "index.html";
    }
}
