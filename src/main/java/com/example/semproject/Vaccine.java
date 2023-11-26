package com.example.semproject;

public class Vaccine {
    private String name;
    private int stock;

    public Vaccine(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
}
