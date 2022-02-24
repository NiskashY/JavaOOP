package com.company.OtherPackage;

import com.company.MainPackage.FirstClass;

public class ThirdClass extends FirstClass{

    @Override
    public String toString() {
        FirstClass fs = new FirstClass();
        return "Allowed " + /*fs.c +*/ fs.d;
    }

}
