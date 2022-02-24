package com.company.professions;

public class Driver {
    int driving_experience;

    public Driver(int driving_experience) {
        this.driving_experience = driving_experience;
    }

    public Driver() {
    }

    public int getDriving_experience() {
        return driving_experience;
    }

    public void setDriving_experience(int driving_experience) {
        this.driving_experience = driving_experience;
    }

    @Override
    public String toString() {
        return "Driving Experience - " + driving_experience;
    }
}