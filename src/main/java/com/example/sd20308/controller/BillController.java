package com.example.sd20308.controller;

import com.example.sd20308.model.Bill;
import com.example.sd20308.model.User;
import com.example.sd20308.repository.BillRepo;
import com.example.sd20308.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class BillController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BillRepo billRepo;

    @GetMapping("/bill/show")
    public String showBill(Model model,
                           @RequestParam("page") Integer page) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        Pageable pageable = PageRequest.of(page, 5);
        Page<Bill> bills = billRepo.findAll(pageable);
        model.addAttribute("bills", bills);
        return "bill";
    }

    @PostMapping("/bill/add")
    public String addBill(@ModelAttribute("bill") Bill bill, Model model) {
        bill.setCreateAt(new Date());
        billRepo.save(bill);
        return "redirect:/bill/show?page=0";
    }

    @GetMapping("/bill/delete")
    public String delete(Model model, @RequestParam("id") Integer id) {
        billRepo.deleteById(id);
        return "redirect:/bill/show?page=0";
    }

    @GetMapping("/bill/detail")
    public String detail(Model model, @RequestParam("id") Integer id) {
        Bill bill = billRepo.findById(id).get();
        List<User> users = userRepo.findAll();
        model.addAttribute("bill", bill);
        model.addAttribute("users", users);
        return "bill-detail.html";
    }

    @PostMapping("/bill/update")
    public String update(@ModelAttribute("bill") Bill bill, Model model) {
        billRepo.save(bill);
        return "redirect:/bill/show?page=0";
    }
}
