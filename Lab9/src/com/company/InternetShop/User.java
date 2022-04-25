package com.company.InternetShop;

import java.util.ArrayList;

public class User extends Basket {
    String login, password;
    Basket basket = new Basket();

    public User() {
    }

    public User(String login, String password, Basket basket) {
        this.login = login;
        this.password = password;
        this.basket = basket;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public User(ArrayList<Product> purchased_items, String login, String password, Basket basket) {
        super(purchased_items);
        this.login = login;
        this.password = password;
        this.basket = basket;
    }

    public User(int price, int rating, String product_name, ArrayList<Product> purchased_items, String login, String password, Basket basket) {
        super(price, rating, product_name, purchased_items);
        this.login = login;
        this.password = password;
        this.basket = basket;
    }
}
