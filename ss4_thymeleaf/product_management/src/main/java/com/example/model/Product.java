package com.example.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String desc;
    private String brand;

    public Product() {
    }

    public Product(String name, double price, String desc, String brand) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.brand = brand;
    }

    public Product(int id, String name, double price, String desc, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
