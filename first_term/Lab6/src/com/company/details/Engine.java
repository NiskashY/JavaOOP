package com.company.details;

public class Engine {
    int capacity;
    String company;

    public Engine(int capacity, String company) {
        this.capacity = capacity;
        this.company = company;
    }

    public Engine() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Capacity - " + capacity + "\nCompany - " + company;
    }
}
