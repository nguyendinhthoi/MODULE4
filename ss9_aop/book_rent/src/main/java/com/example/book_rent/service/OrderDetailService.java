package com.example.book_rent.service;

import com.example.book_rent.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Override
    public boolean save(int bookId, int code, int customerId) {
        orderDetailRepository.save(bookId, code,customerId);
        return true;
    }
}
