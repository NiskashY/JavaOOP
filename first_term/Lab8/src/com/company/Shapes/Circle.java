package com.company.Shapes;

import java.util.Objects;

public class Circle extends Shape{
    int x, y;
    public Circle() {
    }

    public Circle(String color, int x, int y) {
        super(color);
        this.x = x;
        this.y = y;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return x == circle.x && y == circle.y;
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle...\t\t x = " + x + " y = " + y);
    }
}
