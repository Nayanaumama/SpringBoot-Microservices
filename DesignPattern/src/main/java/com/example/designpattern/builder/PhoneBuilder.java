package com.example.designpattern.builder;

public class PhoneBuilder {
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

    PhoneBuilder() {
    }

    public PhoneBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public PhoneBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public PhoneBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public PhoneBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public PhoneBuilder setRam(String ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setCamera(String camera) {
        this.camera = camera;
        return this;
    }

    public PhoneBuilder setBattery(String battery) {
        this.battery = battery;
        return this;
    }

    public PhoneBuilder setDisplay(String display) {
        this.display = display;
        return this;
    }

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setNetwork(String network) {
        this.network = network;
        return this;
    }

    public PhoneBuilder setSecurity(String security) {
        this.security = security;
        return this;
    }
    public Phone getPhone()
    {
        return new Phone(brand,model,price,color,ram,storage,processor,camera,battery,display,os,network,security);
    }
}
