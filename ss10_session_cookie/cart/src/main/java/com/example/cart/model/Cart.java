package com.example.cart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> productIntegerMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public Map<Product, Integer> getProductIntegerMap() {
        return productIntegerMap;
    }

    public void setProductIntegerMap(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            productIntegerMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> integerEntry = selectItemInCart(product);
            Integer newQuantity = integerEntry.getValue() + 1;
            productIntegerMap.replace(integerEntry.getKey(), newQuantity);
        }
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            if (entry.getKey().getProductId() == product.getProductId()) {
                return entry;
            }
        }
        return null;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> productIntegerEntry : productIntegerMap.entrySet()) {
            if (productIntegerEntry.getKey().getProductId() == product.getProductId()) {
                return true;
            }
        }
        return false;
    }

    private Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    private Integer countItemQuantity() {
        return productIntegerMap.size();
    }

    private Double countTotalPayment() {
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : productIntegerMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
