package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {
    @GetMapping("/exchange/calculate")
    public String showForm() {
        return "exchangeForm";
    }

    @PostMapping("/exchange/calculate")
    public String calculate(@RequestParam double vnd, Model model) {
        model.addAttribute("usd",vnd*23000);
        return "exchangeForm";
    }
}
