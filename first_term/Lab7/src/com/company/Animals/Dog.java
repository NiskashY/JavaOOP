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

    public Dog(String name, String food, String location) {
        super(name, food, location, "Dog");
        this.bark = "WOOOF";
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
