package com.company.Animals;

public class Animal {
    String food, location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
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
