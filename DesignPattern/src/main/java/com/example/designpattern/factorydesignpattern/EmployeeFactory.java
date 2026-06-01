package com.example.designpattern.factorydesignpattern;

public class EmployeeFactory {
    public static Employee getEmployee(String type) {
        if (type.equals("JAVADEVELOPER")) {
            return new JavaDeveloper();
        } else if (type.equals("WEBDEVELOPER")) {
            return new WebDeveloper();
        } else if (type.equals("ANDROIDDEVELOPER"))
        {
            return new AndroidDeveloepr();
    }
        else

    {
        return null;
    }
}
}
