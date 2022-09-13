package com.company.Animals;

public class Animal {
    String name, food, location, type;

    public Animal(String name, String food, String location, String type) {
        this.name = name;
        this.food = food;
        this.location = location;
        this.type = type;
    }

    public String getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Animal() {
    }

    public void makeNoise() {
        System.out.println("Какое-то животное шумит");
    }

    public void eat() {
        System.out.println("Какое-то животное ест");
    }

    public void sleep() {
        System.out.println("Какое-то животное спит");
    }

}
