package com.company.InternetShop;

public class Category extends Product {
    String category_name;
    Product[] products;

    public Category() {
    }

    public Category(String category_name, Product[] products) {
        this.category_name = category_name;
        this.products = products;
    }

    public Category(int price, int rating, String product_name, String category_name, Product[] products) {
        super(price, rating, product_name);
        this.category_name = category_name;
        this.products = products;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
