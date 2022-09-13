package com.company.Shapes;

import java.util.Objects;

public class Rectangle extends Shape {
    int x, y;

    public Rectangle(String color, int x, int y) {
        super(color);
        this.x = x;
        this.y = y;
    }

    public Rectangle() {
    }

    @Override
    public void draw() {
        System.out.println("Draw Rectangle...\t x = " + x + " y = " + y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return x == rectangle.x && y == rectangle.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}