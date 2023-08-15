package com.example.caculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("calculator")
public class CalculatorController {
    @GetMapping("")
    public String showCal() {
        return "calculator";
    }
    @PostMapping("calculate")
    public String calculate(RedirectAttributes attributes, @RequestParam("cal")String cal, @RequestParam double num1
            ,@RequestParam double num2) {
            if (Objects.equals(cal, "Addition(+)")) {
                attributes.addFlashAttribute("result", num1 + num2);
            }
            if (Objects.equals(cal, "Subtraction(-)")) {
                attributes.addFlashAttribute("result", num1 - num2);
            }
            if (Objects.equals(cal, "Multiplication(X)")) {
                attributes.addFlashAttribute("result", num1 * num2);
            }
            if (Objects.equals(cal, "Division(/)")) {
                if (num2 == 0){
                    attributes.addFlashAttribute("result1","Can't divide by 0");
                }else {
                    attributes.addFlashAttribute("result", num1 / num2);
                }
            }
        return "redirect:/calculator";
    }
}