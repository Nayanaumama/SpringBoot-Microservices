package com.example.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
  List <Subscriber> subscribers=new ArrayList<>();
  String channelName;
  String videotitle;

  Channel(String ChannelName)
  {
   this.channelName=ChannelName;
  }
  public void SubcribeChannel(Subscriber subscriber)
    {
        subscribers.add(subscriber);
    }
    public void unsubcribeChannel(Subscriber subscriber)
    {
        subscribers.remove(subscriber);
    }
    public void notifySubscribers(String videotitle)
    {
        for(Subscriber sub:subscribers)
        {
            sub.update(this,sub,videotitle);
        }
    }
    public void uploadvideo(String videotitle)
    {
        this.videotitle=videotitle;
        notifySubscribers(videotitle);
    }
}
