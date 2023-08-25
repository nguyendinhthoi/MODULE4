package com.example.book_rent.service;

import com.example.book_rent.model.Book;
import com.example.book_rent.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable, String searchName) {
        return bookRepository.findAll(pageable, "%" + searchName + "%");
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void update(Book book, int bookId) {
        bookRepository.update(book,bookId);
    }


}
