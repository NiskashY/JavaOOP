package com.company;

public class Student {
    String firstNAme, lastName, group;
    double averageMark;

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public int getScholarship() {
        return averageMark == 10 ? 100 : 80;
    }

    public Student(String firstNAme, String lastName, String group, double averageMark) {
        this.firstNAme = firstNAme;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public Student() {}

}
