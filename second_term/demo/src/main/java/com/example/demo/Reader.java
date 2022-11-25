package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class Reader {

    public static <T> ArrayList<T> ReadFromFile(String kFileName) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            File file = new File(kFileName);
            file.createNewFile();

            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(kFileName)
            );
            arrayList = (ArrayList<T>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("CANT READ FILE!");
        }

        return arrayList;
    }

    public static <T> void WriteIntoFile(ArrayList<T> arrayList, String kFileName) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(kFileName)
            );
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println("CANT WRITE INTO FILE!");
        }
    }

}
