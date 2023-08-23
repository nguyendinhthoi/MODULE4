package com.example.form.controller;

import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showCreate(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("")
    public String createUser(@Valid User user, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }else {
            userService.saveUser(user);
            model.addAttribute("message", "ADD SUCCESSFULLY");
            return "result";
        }
    }
}
