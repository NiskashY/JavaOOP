package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class Model {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static Account account = new Account();

    public static Account checkLogin(String input_username, String input_password) {
        Checker existChecker = new ExistChecker(null);
        Checker emptyChecker = new EmptyChecker(existChecker);

        return emptyChecker.doFilter(input_username, input_password);
    }

    public static void AddAccount(Account acc) {
        accounts.add(acc);
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> acc) {
        accounts = acc;
    }

    public static void Notify() {
        for (Account item : accounts) {
            if (!Objects.equals(item.getPassword(), "admin") && !Objects.equals(item.getUsername(), "admin")) {
                item.setAmount_of_products_in_shop(item.getAmount_of_products_in_shop() + 1);
            }
        }
    }

    public static void NotifyHard() {
        ObservableList<Product> productObservableList = FXCollections.observableArrayList(Reader.ReadFromFile("products.txt"));

        for (var item : accounts) {
            if (!Objects.equals(item.getPassword(), "admin") && !Objects.equals(item.getUsername(), "admin")) {
                item.setAmount_of_products_in_shop(productObservableList.size());
            }
        }
    }
}


/*

        if (input_username.isEmpty() && input_password.isEmpty()) {
            return null;
        }

        for (var item : accounts) {
            if (Objects.equals(item.getUsername(), input_username)
                    && item.getPassword().equals(input_password)) {   // if found same login
                return item;
            }
        }

        return null;
 */