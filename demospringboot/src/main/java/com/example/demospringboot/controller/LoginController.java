package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demospringboot.service.AdminService;
import com.example.demospringboot.service.CustomerService;
import com.example.demospringboot.service.KurirService;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demospringboot.entity.Admin;
import com.example.demospringboot.entity.Customer;
import com.example.demospringboot.entity.Kurir;

import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired 
    private CustomerService customerService;

    @Autowired
    private KurirService kurirService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam String nama, @RequestParam String password, Model model) {
        Admin admin = adminService.login(nama, password);
        if (admin != null) {
            return "adminDashboard";
        }
        model.addAttribute("errorMessage", "Invalid username or password");
        return "redirect:/home"; 
    }

    @PostMapping("/customer/login")
    public String loginCustomer(@RequestParam String email, @RequestParam String password, Model model) {
        Customer customer = customerService.login(email, password);
        if (customer != null) {
            return "customerDashboard";
        }
        model.addAttribute("errorMessage", "Invalid username or password");
        return "redirect:/home"; 
    }

    @PostMapping("/kurir/login")
    public String loginKurir(@RequestParam String nama, @RequestParam String password, Model model) {
        Kurir kurir = kurirService.login(nama, password);
        if (kurir != null) {
            return "kurirDashboard";
        }
        model.addAttribute("errorMessage", "Invalid username or password");
        return "redirect:/home";
    }
}