package com.example.demo;
import com.example.demo.Account;

public abstract class Checker {
    private final Checker next;

    public Checker(Checker next) {
        this.next = next;
    }

    public abstract Account doFilter(String input_username, String input_password);

    public Checker getNext() { return this.next; }
}


/*
if (input_username.isEmpty() || input_password.isEmpty()) {
            return null;
        }
 */