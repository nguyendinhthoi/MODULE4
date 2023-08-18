package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Television", 10000000, "Its OK", "SamSung"));
        products.add(new Product(2, "Laptop", 15000000, "Its OK", "Dell"));
        products.add(new Product(3, "Camera", 20000000, "Its OK", "Sony"));
    }

    @Override
    public List<Product> display() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findID(int id) {
        for (Product product : products) {
            if (Objects.equals(id, product.getId())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.set(searchIndex(id), product);
    }

    @Override
    public void delete(int id) {
        products.remove(searchIndex(id));
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products) {
            if (Objects.equals(name, product.getName())) {
                return product;
            }
        }
        return null;
    }

    public int searchIndex(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }
}
