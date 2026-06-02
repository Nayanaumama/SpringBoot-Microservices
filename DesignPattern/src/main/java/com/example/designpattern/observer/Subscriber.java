package com.example.designpattern.observer;

public class Subscriber {

    private String subscribername;
    public Subscriber(String subscribername) {
        this.subscribername = subscribername;
    }

    public void update(Channel channel,Subscriber subscriber,String videotitle) {
        System.out.println(subscriber +  "is notified from "+" "+channel.channelName+" "+"about "+videotitle);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "subscribername='" + subscribername + '\'' +
                '}';
    }
}
