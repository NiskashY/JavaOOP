package Devices;

import java.io.*;
import java.util.Objects;

abstract public class ElectricDevices implements Serializable {
    boolean isPluggedIn = false;
    String modelName = "";
    Date releaseDate;

    int power = 0;

    public ElectricDevices(boolean isPluggedIn, String modelName, Date date) {
        this.isPluggedIn = isPluggedIn;
        this.modelName = modelName;
        this.releaseDate = date;
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    public void setPluggedIn(boolean pluggedIn) {
        isPluggedIn = pluggedIn;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Date getDate() {
        return releaseDate;
    }

    public void setDate(Date date) {
        this.releaseDate = date;
    }

    @Override
    public String toString() {
        return "Is Plugged: " + isPluggedIn +
                ", Model name = " + modelName +
                ", Release date = " + releaseDate;
    }

    static public boolean InputIsPlugged() {
        boolean isPlugged = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Is Currently Plugged? 0 - no, else - yes");

        String choice_tmp = "";
        try {
            choice_tmp = reader.readLine();
        } catch (IOException e) {
            System.out.println("Oshibka tipa");
        }
        isPlugged = Objects.equals(choice_tmp, "0");
        return isPlugged;
    }

    static public String InputModelName() {
        String modelName = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input Model Name");
        try {
            modelName = reader.readLine();
        } catch (IOException e) {
            System.out.println("Oshibka tipa");
        }
        return modelName;
    }

    public int getPower() {
        if (isPluggedIn) {
            return power;
        }
        return 0;
    }
}
