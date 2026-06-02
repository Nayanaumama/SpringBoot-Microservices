package com.example.designpattern.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer player = new MP4Adapter(new MP4Player());
        player.play("abc.mp4");
        MediaPlayer player1 = new Mp3file();
        player1.play("abc.mp3");
    }
}
