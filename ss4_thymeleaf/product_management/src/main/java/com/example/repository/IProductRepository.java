package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> display();

    void add(Product product);

    Product findID(int id);

    void update(int id, Product product);

    void delete(int id);

    Product findByName(String name);
}
