package com.example.userservice.externalService;

import com.example.userservice.entity.Hotel;
import com.example.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("hotelservice")
public interface HotelService {

    @GetMapping("/hotel/getHotelById")
    public Hotel getHotelById(@RequestParam("hotelId") String hotelId);

    @GetMapping("/hotel/getAllHotels")
    public List<Hotel> getAllHotels();


}
