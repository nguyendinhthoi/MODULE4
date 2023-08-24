package com.example.book_rent.controller;


import com.example.book_rent.model.Book;
import com.example.book_rent.service.IBookService;
import com.example.book_rent.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchName,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("book_name").descending());
        Page<Book> libraryDtos = bookService.findAll(pageable, searchName);
        model.addAttribute("searchName", searchName);
        model.addAttribute("library", libraryDtos);
        return "list";
    }

    @GetMapping("/rent/{id}")
    public String rentBook(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "rent";
    }
}
