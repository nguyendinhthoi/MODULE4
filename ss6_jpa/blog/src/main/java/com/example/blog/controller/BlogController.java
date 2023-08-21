package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String blogList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String createBlog(Model model, Blog blog) {
        blogService.save(blog);
        model.addAttribute("message", "Created Successfully");
        return "/blog/create";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(Model model, Blog blog) {
        blogService.save(blog);
        model.addAttribute("message", "Edited Successfully");
        return "/blog/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(Model model, Blog blog) {
        blogService.deleteById(blog.getId());
        model.addAttribute("message", "Deleted Successfully");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable int id) {
        model.addAttribute("blog",blogService.findById(id));
        return "blog/detail";
    }
}
