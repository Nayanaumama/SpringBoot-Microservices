package com.example.designpattern.factorydesignpattern;

public class EmployeeFactoryMainApplication {
    public static void main(String[] args) {
        Employee employee = EmployeeFactory.getEmployee("JAVADEVELOPER");
        System.out.println(employee.getSalary());
        Employee employee1 = EmployeeFactory.getEmployee("WEBDEVELOPER");
        System.out.println(employee1.getSalary());
        Employee employee2 = EmployeeFactory.getEmployee("ANDROIDDEVELOPER");
        System.out.println(employee2.getSalary());
    }
}
