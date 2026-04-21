package com.example.hotelservice.service;

import com.example.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {

    //CreateHotel
    Hotel createHotel(Hotel hotel);

    //get Hotel By id
    Hotel getHotelById(String id);

    //GetAll Hotels
    List<Hotel> getAllHotels();
}
