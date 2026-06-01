package com.example.designpattern.singleton;

public class BookEagerSingleton {

    private static BookEagerSingleton instance = new BookEagerSingleton();//eager way of creating object
    private BookEagerSingleton() {}

    public static BookEagerSingleton getInstance() {
        return instance;
    }
}
