package com.example.blog.controller;

import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
}
