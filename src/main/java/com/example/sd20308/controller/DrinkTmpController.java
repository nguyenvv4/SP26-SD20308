package com.example.sd20308.controller;

import com.example.sd20308.model.DrinkTmp;
import com.example.sd20308.repository.DrinkTmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DrinkTmpController {

    @Autowired
    DrinkTmpRepo drinkTmpRepo;

    @GetMapping("/drink-tmp")
    public String getList(Model model) {
        List<DrinkTmp> drinkTmpList = drinkTmpRepo.getList();
        model.addAttribute("drinkTmpList", drinkTmpList);
        return "drink-tmp.html";
    }
}
