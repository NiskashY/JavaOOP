package com.example.demo;

import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;

    private Integer amount_of_products_in_shop = 0;
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAmount_of_products_in_shop() {
        return amount_of_products_in_shop;
    }

    public void setAmount_of_products_in_shop(int amount_of_products_in_shop) {
        this.amount_of_products_in_shop = amount_of_products_in_shop;
    }
}
