package com.company;

import com.company.Shapes.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Shape> figures = new ArrayList<>();
        int amount_of_shapes = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Input amount of figures: ");
            amount_of_shapes = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (amount_of_shapes != 0){
            String color = "";
            int x = 0, y = 0;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Input color: ");
                color = reader.readLine();
                System.out.print("Input x: ");
                x = Integer.parseInt(reader.readLine());
                System.out.print("Input y: ");
                y = Integer.parseInt(reader.readLine());
                System.out.print("Input shape(circle - 1, else - rectangle): ");
                String shape = reader.readLine();
                if (Objects.equals(shape, "1")) {
                    figures.add(new Circle(color, x, y));
                }
                else {
                    figures.add(new Rectangle(color, x, y));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            amount_of_shapes--;
        }

        for (final var item : figures) {
            item.draw();
        }

    }
}
