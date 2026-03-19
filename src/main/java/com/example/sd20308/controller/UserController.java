package com.example.sd20308.controller;


import com.example.sd20308.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    ArrayList<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1, "nguyenvv4@fpt.edu.vn", "0987654321", "Vu Van Nguyen", "123456", true, true));
        users.add(new User(2, "nguyenvv5@fpt.edu.vn", "0887654321", "Tran Tuan Phong", "123456", true, false));
        users.add(new User(3, "nguyenvv6@fpt.edu.vn", "0787654321", "Nguyen Hoang Tien", "123456", false, true));
        users.add(new User(4, "nguyenvv7@fpt.edu.vn", "0687654321", "Nguyen Anh Dung", "123456", true, false));
        users.add(new User(5, "nguyenvv8@fpt.edu.vn", "0587654321", "NGuyen Quang Ha", "123456", false, true));

    }
    @PostMapping("/search")
    public String search(Model model, @RequestParam("phone") String phone) {
        User result = new User();
        for (User u : users) {
            if (u.getPhone().equals(phone)) {
                result = u;
            }
        }
        model.addAttribute("user", result);
        return "user-detail.html";

    }

    @GetMapping("/list-user")
    public String listUser(Model model) {

        // truyen danh sach user cho UI
        model.addAttribute("users", users);
        return "index.html";
    }

    @GetMapping("/detail")
    public String detail(Model model) {
        return "user-detail.html";
    }


}
