package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private String model;
    private boolean isBooked;

    public Car () {
        isBooked = false;
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, boolean isBooked) {
        this.model = model;
        this.isBooked = isBooked;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isBooked == car.isBooked && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, isBooked);
    }

    @Override
    public String toString() {
        return "Car: model = '" + model + "', isBooked = " + isBooked;
    }
}
