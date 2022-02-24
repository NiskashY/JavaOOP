package com.company;

import com.company.Animals.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Animal dog = new Dog("Meat", "Bathroom", "WOOOF");
        Animal cat = new Cat("Fish", "Kitchen", "MEOOOOW");
        Animal horse = new Horse("hay", "Outside", "BRRRR");

        Animal[] animals = {dog, cat, horse};
        for (final var i : animals) {
            i.makeNoise();
            i.eat();
            i.sleep();
            System.out.println();
        }

    }
}
