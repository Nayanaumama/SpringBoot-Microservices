package com.example.designpattern.strategy;

public class ShoppingCArt {
    private PaymentStrategy paymentStrategy;
public ShoppingCArt(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;

    }
    public void checkout(double amount){
    paymentStrategy.pay(amount);
    }
}
