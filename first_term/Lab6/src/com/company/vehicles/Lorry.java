package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class Lorry extends Car {
    public int carrying;

    public Lorry(String brand, String car_class, int weight, Driver driver, Engine engine, int carrying) {
        super(brand, car_class, weight, driver, engine);
        this.carrying = carrying;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public Lorry(int carrying) {
        this.carrying = carrying;
    }

    public Lorry() {}

    @Override
    public String toString() {
        return super.toString() + "\nCarrying - " + carrying;
    }
}
