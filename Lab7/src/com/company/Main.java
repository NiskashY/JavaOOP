package com.company;

import com.company.Animals.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here

        ArrayList<ArrayList<Animal>> all_animals = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            System.out.println("Input amount of animals of current type u want to add");
            int amount = 0;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                amount = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<Animal> current_animals = new ArrayList<>();

            for (int j = 0; j < amount; ++j) {
                String name, food, location;
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    if (i == 0){
                        System.out.println("Input Dog name, food and location:");
                        name = reader.readLine();
                        food = reader.readLine();
                        location = reader.readLine();

                        Animal dog = new Dog(name, food, location);
                        current_animals.add(dog);
                    }
                    else if (i == 1) {
                        System.out.println("Input Cat food and location:");
                        name = reader.readLine();
                        food = reader.readLine();
                        location = reader.readLine();

                        Animal cat = new Cat(name, food, location);
                        current_animals.add(cat);
                    }
                    else {
                        System.out.println("Input Horse food and location:");
                        name = reader.readLine();
                        food = reader.readLine();
                        location = reader.readLine();

                        Animal horse = new Horse(name, food, location);
                        current_animals.add(horse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            all_animals.add(current_animals);
        }

        for (var i : all_animals) {
            for (var animal : i) {
                int tmp = 0;
                System.out.println("You want to treat this animal? (name - " + animal.getName() + ", type - " + animal.getType() + ") 1 - y, else - n");
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                     tmp = Integer.parseInt(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (tmp == 1) {
                    Vet vet = new Vet();
                    vet.treatAnimal(animal);
                    System.out.println();
                }
            }
        }

    }
}
