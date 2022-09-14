package com.company.professions;

public class Person extends Driver {
    private int age;
    String fullName;

    public Person(int driving_experience, int age, String fullName) {
        super(driving_experience);
        this.age = age;
        this.fullName = fullName;
    }

    public Person(int age, String fullName) {
        this.age = age;
        this.fullName = fullName;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Age - " + age
                + "\nFull Name - " + fullName;
    }
}
