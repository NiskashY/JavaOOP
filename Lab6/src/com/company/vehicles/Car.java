package com.company.vehicles;

import com.company.professions.Driver;
import com.company.details.Engine;

public class Car{
    String brand;
    String car_class;
    int weight;
    Driver driver;
    Engine engine;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCar_class() {
        return car_class;
    }

    public void setCar_class(String car_class) {
        this.car_class = car_class;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car(String brand, String car_class, int weight, Driver driver, Engine engine) {
        this.brand = brand;
        this.car_class = car_class;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public Car() {
    }

    public void start() {
        System.out.println("Поехали");
    }

    public void stop() {
        System.out.println("Останавливаемся");
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }

    public String ToString() {
        return ("Brand - " + brand + "\nCar class - " + car_class +
                "\nWeight - " + weight + "\n" + driver.toString() +
                "\n" + engine.toString());
    }
}
