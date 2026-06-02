package com.example.designpattern.builder;

public class Phone {
    String brand;
    String model;
    int price;
    String color;
    String ram;
    String storage;
    String processor;
    String camera;
    String battery;
    String display;
    String os;
    String network;
    String security;

    public Phone(String brand, String model, int price, String color, String ram, String storage, String processor, String camera, String battery, String display, String os, String network, String security) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.ram = ram;
        this.storage = storage;
        this.processor = processor;
        this.camera = camera;
        this.battery = battery;
        this.display = display;
        this.os = os;
        this.network = network;
        this.security = security;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", processor='" + processor + '\'' +
                ", camera='" + camera + '\'' +
                ", battery='" + battery + '\'' +
                ", display='" + display + '\'' +
                ", os='" + os + '\'' +
                ", network='" + network + '\'' +
                ", security='" + security + '\'' +
                '}';
    }

    public Phone() {
    }


}
