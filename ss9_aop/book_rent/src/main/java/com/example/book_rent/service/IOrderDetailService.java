package com.example.book_rent.service;

import com.example.book_rent.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderDetailService {
    boolean save(int bookId, int code, int customerId);

    Page<OrderDetail> findAll(Pageable pageable);

    OrderDetail findById(int id);

    void deleteOrder(int id);

    OrderDetail findByCode(int id);
}
