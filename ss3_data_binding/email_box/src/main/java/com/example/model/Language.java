package com.example.model;

import java.util.List;

public class Language {
    private int id;
    private String name;
    private int size;
    private int filter;
    private String signature;

    public Language() {
    }

    public Language(String name, int size, int filter, String signature) {
        this.name = name;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public Language(int id, String name, int size, int filter, String signature) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
