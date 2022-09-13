package com.company;

import com.company.vehicles.*;
import com.company.details.*;
import com.company.professions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String symbol = "s";

         while (!Objects.equals(symbol, "q")){

            String brand, car_class, company;
            int weight, driving_experience, capacity;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Brand: ");
                brand = reader.readLine();

                System.out.print("Car class ");
                car_class = reader.readLine();

                System.out.print("Weight: ");
                weight = Integer.parseInt(reader.readLine());

                System.out.print("Driver experience: ");
                driving_experience = Integer.parseInt(reader.readLine());

                System.out.print("Engine capacity: ");
                capacity = Integer.parseInt(reader.readLine());

                System.out.print("Engine company: ");
                company = reader.readLine();

                int choice;
                System.out.println("Choose what u want to use: Car - 1, Lorry - 2, SportCar - 3");
                choice = Integer.parseInt(reader.readLine());

                Car someCar;
                if (choice == 1) {
                    someCar = new Car(brand, car_class, weight, new Driver(driving_experience), new Engine(capacity, company));
                } else if (choice == 2) {
                    int carrying;
                    System.out.print("Carrying: ");
                    carrying = Integer.parseInt(reader.readLine());
                    someCar = new Lorry(brand, car_class, weight, new Driver(driving_experience), new Engine(capacity, company), carrying);
                } else {
                    int speed;
                    System.out.print("Speed: ");
                    speed = Integer.parseInt(reader.readLine());
                    someCar = new SportCar(brand, car_class, weight, new Driver(driving_experience), new Engine(capacity, company), speed);
                }

                System.out.println(someCar);
                someCar.start();
                someCar.turnLeft();
                someCar.turnRight();

                System.out.print("Want to exit? q - YES, else - NO");
                symbol = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
