package com.company;

import com.company.vehicles.*;
import com.company.details.*;
import com.company.professions.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Driver x = new Driver(15);
//        System.out.println(x.ToString());

        Car x = new Car("120", "120",1,new Driver(10),new Engine(10, "BWM"));
        System.out.println(x.ToString());
        x.start();


    }
}
