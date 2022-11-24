package com.example.demo;

public class EmptyChecker extends Checker {
    public EmptyChecker(Checker next) {
        super(next);
    }

    public Account doFilter(String input_username, String input_password) {
        if (input_username.isEmpty() || input_password.isEmpty()) {
            return null;
        }

        return this.getNext().doFilter(input_username, input_password);
    }
}
