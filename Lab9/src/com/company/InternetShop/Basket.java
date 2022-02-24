package com.company.InternetShop;

public class Basket extends Product {
    Product[] purchased_items;

    public Basket() {
    }

    public Basket(Product[] purchased_items) {
        this.purchased_items = purchased_items;
    }

    public Product[] getPurchased_items() {
        return purchased_items;
    }

    public void setPurchased_items(Product[] purchased_items) {
        this.purchased_items = purchased_items;
    }

    public Basket(int price, int rating, String product_name, Product[] purchased_items) {
        super(price, rating, product_name);
        this.purchased_items = purchased_items;
    }
}
