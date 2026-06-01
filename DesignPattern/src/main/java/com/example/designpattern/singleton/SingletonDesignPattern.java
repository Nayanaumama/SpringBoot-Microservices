package com.example.designpattern.singleton;

public class SingletonDesignPattern {

    public static void main(String[] args) {
        BookLazySingleton bookLazySingleton = BookLazySingleton.getInstance();
        BookLazySingleton bookLazySingleton2 = BookLazySingleton.getInstance();
        BookEagerSingleton bookEagerSingleton = BookEagerSingleton.getInstance();
        BookEagerSingleton bookEagerSingleton2 = BookEagerSingleton.getInstance();
        System.out.println(bookLazySingleton == bookLazySingleton2);
        System.out.println(bookEagerSingleton == bookEagerSingleton2);


    }


}
