package Devices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Date {
    int day = 0;
    int month = 0;
    int year = 0;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    static public Date InputDate() {
        int day = 0, month = 0, year = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input day: ");
            day = Integer.parseInt(reader.readLine());
            System.out.println("Input month: ");
            month = Integer.parseInt(reader.readLine());
            System.out.println("Input year: ");
            year = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Oshibka tipa");
        }

        return new Date(day, month, year);
    }
}
