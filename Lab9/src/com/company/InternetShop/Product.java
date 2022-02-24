package com.company.InternetShop;

public class Product {
    int price, rating;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    String product_name;

    public Product() {
    }

    public Product(int price, int rating, String product_name) {
        this.price = price;
        this.rating = rating;
        this.product_name = product_name;
    }

}
