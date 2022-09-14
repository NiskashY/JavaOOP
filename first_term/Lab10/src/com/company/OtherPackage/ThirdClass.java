package com.company.OtherPackage;

import com.company.MainPackage.FirstClass;

public class ThirdClass extends FirstClass{

    @Override
    public String toString() {
        return "Allowed " + c + d;
    }

}
