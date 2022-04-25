package com.company.Animals;

public class Cat extends Animal{
    String meow = "meow";

    public Cat() {
    }

    public Cat(String meow) {
        this.meow = meow;
    }

    public Cat(String name, String food, String location) {
        super(name, food, location, "Cat");
        this.meow = "MEOOOOW";
    }

    @Override
    public void makeNoise() {
        System.out.println("Кот шумит: " + location + " " + meow);
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    @Override
    public void eat() {
        System.out.println("Кот ест: " + food);
    }
}
