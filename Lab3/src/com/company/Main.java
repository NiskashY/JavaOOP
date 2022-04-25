package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        int amount = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input: ");
            amount = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Создаю массив из amount пользовтелей библотеки.

        LibraryReaders[] library_readers = new LibraryReaders[amount];

        for (int i = 0; i < amount; ++i) {
            library_readers[i] = new LibraryReaders();
            library_readers[i].setFio("Evgenii E. A.");
            library_readers[i].takeBook("Э", "Котлован");
            library_readers[i].takeBook(new Book("A", "B"),
                    new Book("C", "D"),
                    new Book("E", "F"));
        }

        System.out.println("OK!");

    }
}
