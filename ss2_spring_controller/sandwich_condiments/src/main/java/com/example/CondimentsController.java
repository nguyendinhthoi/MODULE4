package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/condiments")
public class CondimentsController {
    @GetMapping("")
    public String showList() {
        return "list";
    }

    @PostMapping("/save")
    public String save(RedirectAttributes redirectAttributes, @RequestParam(name = "condiment", required = false,defaultValue = "Let choose something") String[] condiment) {
        redirectAttributes.addFlashAttribute("mess", Arrays.toString(condiment));
        return "redirect:/condiments";
    }
}
