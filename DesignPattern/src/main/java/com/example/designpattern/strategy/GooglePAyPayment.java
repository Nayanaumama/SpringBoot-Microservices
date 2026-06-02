package com.example.designpattern.strategy;

public class GooglePAyPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paying using google pay");
    }
}
