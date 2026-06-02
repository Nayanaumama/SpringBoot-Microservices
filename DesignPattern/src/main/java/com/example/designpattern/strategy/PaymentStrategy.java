package com.example.designpattern.strategy;
//**Strategy Pattern** means: define multiple ways/algorithms to do something, and choose one at runtime.
//        Example: Payment system
//- Pay by credit card
//- Pay by UPI
//- Pay by PayPal
//
//All are different payment strategie
//instead of using if else it replaces that with seperate logic for each implemetation and decide during runtime
//its behaviour design pattern



public interface PaymentStrategy {
    void pay(double amount);
}
