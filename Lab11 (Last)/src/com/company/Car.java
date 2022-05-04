package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {
    private String model;
    private boolean isBroken;

    public Car () {
        isBroken = false;
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, boolean isBroken) {
        this.model = model;
        this.isBroken = isBroken;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isBroken == car.isBroken && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, isBroken);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", isBroken=" + isBroken +
                '}';
    }
}
