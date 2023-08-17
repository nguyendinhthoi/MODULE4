package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
   private IProductRepo productRepo;

    @Override
    public List<Product> display() {
        return productRepo.display();
    }

    @Override
    public void add(Product product) {
        productRepo.add(product);
    }

    @Override
    public Product findID(int id) {
        return productRepo.findID(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepo.update(id,product);
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name);
    }
}
