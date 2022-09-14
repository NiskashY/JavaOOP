package com.company;

import com.company.MainPackage.DerivedFirstClass;
import com.company.MainPackage.FirstClass;
import com.company.MainPackage.SecondClass;
import com.company.OtherPackage.ThirdClass;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FirstClass mainClass = new FirstClass();
        SecondClass second = new SecondClass();
        ThirdClass thirdClass = new ThirdClass();
        DerivedFirstClass derivedFirstClass = new DerivedFirstClass();

        System.out.println("Main class " + mainClass.toString());
        System.out.println("SecondClass class " + second.toString());
        System.out.println("ThirdClass class " + thirdClass.toString());
        System.out.println("DerivedFirstClass class " + derivedFirstClass.toString());

    }
}
