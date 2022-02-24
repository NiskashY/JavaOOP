package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Student person1 = new Student("Петр", "Первый",
                                    "1", 7);
        Aspirant person2 = new Aspirant("Евгений", "Евген", "2",
                                8, "Scince !");

        Student person3 = new Aspirant("Даниил", "Дан", "3",
                8, "ненене !");

        Student[] persons = {person1, person2, person3};
        for (final var item : persons) {
            System.out.println(item.getScholarship());
        }


    }
}
