package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> products = productService.display();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "you have successfully added");
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam int id) {
        Product product = productService.findID(id);
        if (product == null) {
            model.addAttribute("mess", "Your Product don't exist");
        } else {
            model.addAttribute("product", product);
        }
        return "edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@RequestParam int id, @ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(id, product);
        redirectAttributes.addFlashAttribute("mess", "you have successfully edited");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "you have successfully deleted");
        return "redirect:/product";
    }

    @GetMapping("/view")
    public String showView(@RequestParam int id, Model model) {
        Product product = productService.findID(id);
        if (product == null) {
            model.addAttribute("mess", "Your Product don't exist");
        } else {
            model.addAttribute("product", product);
        }
        return "view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        Product product = productService.findByName(name);
        if (product == null) {
            model.addAttribute("mess", "Your Product don't exist");
        } else {
            model.addAttribute("product", product);
        }
        return "view";
    }
}
