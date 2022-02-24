package com.company;

public class Person {
    String fullName;
    int age;

    public void move() {
        System.out.println("Такой-то " + fullName + " двигается");
    }

    public void talk() {
        System.out.println("Такой-то " + fullName + " говорит");
    }

    public void jump() {
        System.out.println("Такой-то " + fullName + " прыгает");
    }

    public Person() {
        fullName = "Igor";
        age = 27;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String new_fullName, int new_age) {
        fullName = new_fullName;
        age = new_age;
    }
}
