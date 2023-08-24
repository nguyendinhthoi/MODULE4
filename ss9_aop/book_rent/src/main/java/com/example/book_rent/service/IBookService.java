package com.example.book_rent.service;

import com.example.book_rent.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable, String searchName);

    Book findById(int id);
}
