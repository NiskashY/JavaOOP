package com.company.Shapes;

public abstract class Shape {
    String color;

    public Shape(){    }

    public Shape(String color){
        this.color = color;
    }

    abstract public void draw();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract public boolean equals(Object o);
}
