package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void inputInformation( Phone phone) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Input Model of the phone: ");
            phone.setModel(in.readLine());

            System.out.print("Input Weight of the phone: ");
            phone.setWeight(Integer.parseInt(in.readLine()));

            System.out.print("Input Number of the phone: ");
            phone.setNumber(in.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Phone first_phone = new Phone();
        Phone second_phone = new Phone();
        Phone third_phone = new Phone();

        inputInformation(first_phone);
        first_phone.showSpecs();

    }
}