package com.company.Animals;

public class Horse extends Animal {
    String br = "br";

    public Horse() {
    }

    public Horse(String br) {
        this.br = br;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public Horse(String food, String location, String br) {
        super(food, location);
        this.br = br;
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь шумит: " + location + " " + br);
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест: " + food);
    }
}
