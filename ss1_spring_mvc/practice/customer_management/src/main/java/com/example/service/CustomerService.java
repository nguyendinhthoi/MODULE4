package com.example.service;

import com.example.model.Customer;
import com.example.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> showList() {
        return customerRepo.showList();
    }

    @Override
    public Customer findId(int id) {
        return customerRepo.findId(id);
    }
}
