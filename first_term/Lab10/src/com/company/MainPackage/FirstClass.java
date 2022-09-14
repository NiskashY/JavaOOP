package com.company.MainPackage;

public class FirstClass {
    private String a = "private ";
    String b = "default ";
    protected String c = "protected ";
    public String d = "public ";

    @Override
    public String toString() {
        return "Allowed " +  a + b + c + d;
    }
}