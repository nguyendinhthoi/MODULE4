package com.example.book_rent.controller;


import com.example.book_rent.model.Book;
import com.example.book_rent.model.Customer;
import com.example.book_rent.service.IBookService;
import com.example.book_rent.service.ICategoryService;
import com.example.book_rent.service.ICustomerService;
import com.example.book_rent.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IOrderDetailService orderDetailService;

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
    public String showRentBook(@PathVariable int id, Model model) {
        Book book = bookService.findById(id);
        List<Customer> customers = customerService.findAll();
        String code = book.generateRandomCode();
        model.addAttribute("code", code);
        model.addAttribute("customers", customers);
        model.addAttribute("book", book);
        return "rent";
    }

    @PostMapping("/rent")
    public String rentBook(RedirectAttributes redirectAttributes, Book book, @RequestParam int customerId, @RequestParam String code) {
        if (orderDetailService.save(book.getBookId(), Integer.parseInt(code), customerId)) {
            book.setQuantity(book.getQuantity() - 1);
            bookService.update(book, book.getBookId());
        }
        redirectAttributes.addFlashAttribute("message", "Rent successfully");
        return "redirect:/library";
    }
}
