package com.example.book_rent.service;

import com.example.book_rent.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
