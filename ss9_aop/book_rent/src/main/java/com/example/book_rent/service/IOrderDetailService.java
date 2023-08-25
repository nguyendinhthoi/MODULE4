package com.example.book_rent.service;

public interface IOrderDetailService {
    boolean save(int bookId, int code, int customerId);
}
