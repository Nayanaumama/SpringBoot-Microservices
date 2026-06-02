package com.example.designpattern.adapter;

public class MP4Adapter implements MediaPlayer{
    MP4Player mp4Player ;
    public MP4Adapter(MP4Player mp4Player){
        this.mp4Player = mp4Player;
    }
    @Override
    public void play(String fileName) {
        mp4Player.playMP4(fileName);
    }
}
