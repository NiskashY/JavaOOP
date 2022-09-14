package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class SportCar extends Car {
    double speed;

    public SportCar(String brand, String car_class, int weight, Driver driver, Engine engine, double speed) {
        super(brand, car_class, weight, driver, engine);
        this.speed = speed;
    }

    public SportCar(double speed) {
        this.speed = speed;
    }

    public SportCar() {
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeed - " + speed;
    }
}
