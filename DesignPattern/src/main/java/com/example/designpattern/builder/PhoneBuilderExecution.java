package com.example.designpattern.builder;

public class PhoneBuilderExecution {
    public static void main(String[] args) {
        Phone phone = new PhoneBuilder().setBrand("Samsung").setModel("Galaxy S20").setPrice(100000).setOs("Android").getPhone();
        System.out.println(phone);
        Phone phone2=new PhoneBuilder().setCamera("12m").setBattery("4000mAh").setDisplay("6.5inch").setOs("Android").getPhone();
        System.out.println(phone2);
    }}