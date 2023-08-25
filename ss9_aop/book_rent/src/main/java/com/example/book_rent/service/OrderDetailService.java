package com.example.book_rent.service;

import com.example.book_rent.model.OrderDetail;
import com.example.book_rent.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Override
    public boolean save(int bookId, int code, int customerId) {
        orderDetailRepository.save(bookId, code, customerId);
        return true;
    }

    @Override
    public Page<OrderDetail> findAll(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public OrderDetail findById(int id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public void deleteOrder(int id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public OrderDetail findByCode(int id) {
        return orderDetailRepository.findByCode(id);
    }
}
