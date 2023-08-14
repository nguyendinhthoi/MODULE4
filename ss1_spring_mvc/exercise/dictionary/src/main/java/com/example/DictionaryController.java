package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary/searchForm")
    public String showForm() {
        return "searchForm";
    }

    @PostMapping("/dictionary/searchForm")
    public String search(@RequestParam String en, Model model) {
        Map<String, String> stringMap = new TreeMap<>();
        stringMap.put("love", "Tình yêu");
        stringMap.put("home", "Nhà");
        stringMap.put("boo", "Em yêu");
        if (stringMap.containsKey(en)) {
            model.addAttribute("vn", stringMap.get(en));
            return "searchForm";
        } else {
            model.addAttribute("message","Not found");
            return "searchForm";
        }
    }
}
