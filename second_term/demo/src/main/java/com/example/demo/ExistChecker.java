package com.example.demo;

import java.util.Objects;

public class ExistChecker extends Checker {
    public ExistChecker(Checker next) {
        super(next);
    }

    public Account doFilter(final String input_username, final String input_password) {
        for (var item : Model.accounts) {
            if (Objects.equals(item.getUsername(), input_username) &&
                    Objects.equals(item.getPassword(), input_password)) {
                return item;
            }
        }
        return null;
    }
}
