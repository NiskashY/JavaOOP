package com.company.MainPackage;

public class SecondClass {

    @Override
    public String toString() {
        FirstClass fc = new FirstClass();
        return "Allowed " + fc.b + fc.c + fc.d;
    }
}
