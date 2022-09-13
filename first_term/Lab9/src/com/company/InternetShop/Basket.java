package com.company.InternetShop;

import java.util.ArrayList;

public class Basket extends Product {
    ArrayList<Product> purchased_items = new ArrayList<>();

    public Basket() {
    }

    public Basket( ArrayList<Product> purchased_items) {
        this.purchased_items = purchased_items;
    }

    public ArrayList<Product> getPurchased_items() {
        return purchased_items;
    }

    public void setPurchased_items( ArrayList<Product> purchased_items) {
        this.purchased_items = purchased_items;
    }

    public void AddItem( Product purchased_item) {
        this.purchased_items.add(purchased_item);
    }

    public Basket(int price, int rating, String product_name,  ArrayList<Product> purchased_items) {
        super(price, rating, product_name);
        this.purchased_items = purchased_items;
    }
}
