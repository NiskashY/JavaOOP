package com.example.demo;

import java.io.Serializable;

public class Product implements Serializable {
    private String name, price, amount, weight;

    public Product(String name, String price, String amount, String weight) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}