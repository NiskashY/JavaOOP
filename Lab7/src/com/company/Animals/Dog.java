package com.company.Animals;

public class Dog extends Animal {
    String bark = "Woof";

    public Dog() {
    }

    public Dog(String bark) {
        this.bark = bark;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }

    public Dog(String food, String location, String bark) {
        super(food, location);
        this.bark = bark;
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака шумит: " + location + " " + bark);
    }

    @Override
    public void eat() {
        System.out.println("Собака ест: " + food);
    }

}
