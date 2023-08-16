package com.example.controller;

import com.example.model.Language;
import com.example.repository.ILanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    ILanguageRepo languageRepo;

    @GetMapping("")
    public String showForm(Model model) {
        List<Language> languages = languageRepo.display();
        model.addAttribute("languages", languages);
        return "list";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        Language language = languageRepo.findID(id);
        List<String> stringList = languageRepo.displayName();
        List<Integer> integerList = languageRepo.displaySize();
        model.addAttribute("language", language);
        model.addAttribute("listName", stringList);
        model.addAttribute("listSize", integerList);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Language language, RedirectAttributes redirectAttributes) {
        languageRepo.update(language,language.getId());
        redirectAttributes.addFlashAttribute("message", "The Language was updated");
        return "redirect:/language/list";
    }
}
