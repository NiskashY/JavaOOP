package com.company;

import com.company.Shapes.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Shape circle = new Circle("blue", 5, 3);
        Shape rectangle = new Circle("green", 15, 31);

        Shape[] figures = {circle, rectangle};

        for (final var item : figures) {
            item.draw();
        }

    }
}
