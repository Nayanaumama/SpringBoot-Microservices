package com.example.designpattern.singleton;

public class BookLazySingleton {
    private static BookLazySingleton instance;//Lazy initialization
    private BookLazySingleton() {}
    public static BookLazySingleton getInstance() {
        if (instance == null) {
            synchronized (BookLazySingleton.class) {//Making thread safe .when there are multiple threads try tp
                //access then there will be chances of multiple threads create object at once .So making it thread safe .
                if (instance == null)
                    instance = new BookLazySingleton();

            }
        }
        return instance;
    }
}
