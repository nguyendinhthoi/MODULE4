package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> display();

    void add(Product product);

    Product findID(int id);

    void update(Product product);

    void delete(int id);

    Product findByName(String name);
}
