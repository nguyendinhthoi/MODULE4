package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/customer/list")
    public String showList(Model model) {
        List<Customer> customerList = customerService.showList();
        model.addAttribute("customer", customerList);
        return "list";
    }

    @GetMapping("/customer/info")
    public String showInfo(Model model, @RequestParam int id) {
        Customer customer = customerService.findId(id);
        model.addAttribute("customer",customer);
        return "info";
    }
}
