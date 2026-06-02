package com.example.designpattern.observer;

public class Youtube {
    public static void main(String[] args) {


        Subscriber subscriber = new Subscriber("Nayana");
        Subscriber subscriber1 = new Subscriber("Nikitha");
        Subscriber subscriber2 = new Subscriber("Nishita");
        Subscriber subscriber3 = new Subscriber("Nisha");
        Channel drBro = new Channel("drBro");

        drBro.SubcribeChannel(subscriber);
        drBro.SubcribeChannel(subscriber1);
        drBro.SubcribeChannel(subscriber2);
        drBro.SubcribeChannel(subscriber3);
       drBro.uploadvideo("Java Observer Design Pattern is uploaded on Youtube");


    }
}
