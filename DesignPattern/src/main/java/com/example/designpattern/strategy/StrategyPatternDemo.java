package com.example.designpattern.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCArt shoppingCart = new ShoppingCArt(new GooglePAyPayment());
        shoppingCart.checkout(1000);
        ShoppingCArt shoppingCart1 = new ShoppingCArt(new CreditCardPAyment());
        shoppingCart1.checkout(1000);
        ShoppingCArt shoppingCart2 = new ShoppingCArt(new CashPayment());
        shoppingCart2.checkout(1000);
    }
}
