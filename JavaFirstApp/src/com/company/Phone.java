package com.company;

public class Phone {
    private String number, model;
    private int weight;

    Phone(String new_number, int new_weight, String new_model) {
        this(new_number, new_model);
        weight = new_weight;
    }

    Phone(String new_number, String new_model) {
        number = new_number;
        model = new_model;
    }

    Phone() {}

    public String getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    public String getModel() {
        return model;
    }

    public void setNumber(String new_number) {
        number = new_number;
    }

    public void setModel(String new_model) {
        model = new_model;
    }

    public void setWeight(int new_weight) {
        weight = new_weight;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит {" + name + "}");
    }

    public void receiveCall(String receive_name, String receive_number){
        System.out.println("Звонит {" + receive_name + "}");
        System.out.println("\t" + receive_number);
    }

    public void sendMessage(String ... numbers) {
        System.out.println("Message will be derived for these numbers:");
        for (final String item : numbers) {
            System.out.println(item);
        }
    }

    public final void showSpecs() {
        System.out.println("Model - " + model);
        System.out.println("Weight - " + weight);
        System.out.println("Number - " + number);
    }
}
