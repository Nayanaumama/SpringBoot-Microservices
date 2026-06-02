package com.example.designpattern.adapter;
//The **Adapter Design Pattern** is used when two classes/interfaces are not compatible, but you want them to work together.
//It acts like a **bridge** between an existing class and the interface your code expects.
public class Mp3file implements MediaPlayer{
    @Override
    public void play(String fileName) {
        System.out.println("Playing mp3 file. Name: "+fileName);
    }
}
