package com.example.springbootexceptionhandling.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String employeeNotFound) {
    }

}
