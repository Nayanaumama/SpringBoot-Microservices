package com.example.designpattern.strategy;

public class CashPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paying using cash");
    }
}
