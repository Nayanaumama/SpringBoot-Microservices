package com.example.designpattern.strategy;

public class CreditCardPAyment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paying using credit card");
    }
}
