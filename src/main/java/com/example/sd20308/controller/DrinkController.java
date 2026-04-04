package com.example.sd20308.controller;

import com.example.sd20308.model.Category;
import com.example.sd20308.model.Drink;
import com.example.sd20308.repository.CategoryRepo;
import com.example.sd20308.repository.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DrinkController {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    DrinkRepo drinkRepo;

    @GetMapping("/drink")
    public String home(Model model) {
        List<Category> listCategory = categoryRepo.findAll();
        model.addAttribute("listCategory", listCategory);
        return "drink";

    }

    @PostMapping("/add")
    public String add(Drink drink, Model model) {
        System.out.println(drink.toString());
        model.addAttribute("category", new Category());
        drinkRepo.save(drink);
        return "redirect:/drink";
    }

    @GetMapping("/page")
    public String page(
            @RequestParam("pageNumber") Integer pageNumber,
            @RequestParam("pageSize") Integer pageSize,
            Model model
    ) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Drink> drinks = drinkRepo.findAll(pageable);
        model.addAttribute("drinks", drinks);
        return "drink";
    }

}
