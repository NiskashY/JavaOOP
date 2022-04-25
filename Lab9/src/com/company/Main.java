package com.company;

import com.company.InternetShop.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void foo(Basket basket, Product i) {
        System.out.print("You want to add " + i.getProduct_name() + "? 1 - y, else -n");
        int wantToAdd = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            wantToAdd = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wantToAdd == 1) {
            basket.AddItem(i);
        }
    }
    public static void main(String[] args) {
	// write your code here


        Product tomato = new Product(10, 5, "tomato");
        Product cucumber = new Product(25, 3, "cucmber");
        Product corn = new Product(15, 4, "corn");
        Category vegetables = new Category("vegetables", new Product[]{tomato, cucumber, corn});

        Product saint_spring = new Product(5, 5, "saint_spring");
        Product darida = new Product(10, 1, "darida");
        Product borjomi = new Product(8, 4, "borjomi");
        Category water = new Category("water", new Product[]{saint_spring, darida, borjomi});

        Product seld = new Product(10, 5, "seld");
        Product treska = new Product(25, 3, "treska");
        Product okun = new Product(15, 4, "okun");
        Category fish = new Category("fish", new Product[]{seld, treska, okun});


        int type = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("category(1 - water, 2 - fish, else - vegetbles): ");
            type = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Basket basket = new Basket();
        switch (type) {
            case 1 -> {
                for (var i : water.getProducts()) {
                    foo(basket, i);
                }
            }
            case 2 -> {
                for (var i : fish.getProducts()) {
                    foo(basket, i);
                }
            }
            case 3 -> {
                for (var i : vegetables.getProducts()) {
                    foo(basket, i);
                }
            }
        }

        System.out.print("Представтесь input login + password: ");
        String login = "", password = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            login = reader.readLine();
            password = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User(login, password, basket);

        System.out.println(login + " " + password + " basket:");
        var bask = user.getBasket();
        for (var item : bask.getPurchased_items()) {
            System.out.println(item.getProduct_name());
        }

    }
}
