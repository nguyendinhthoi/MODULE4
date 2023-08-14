package com.example.repository;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> showList();

    Customer findId(int id);
}
