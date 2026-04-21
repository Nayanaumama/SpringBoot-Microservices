package com.example.hotelservice.controller;

import com.example.hotelservice.entity.Hotel;
import com.example.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel hotel1=hotelService.createHotel(hotel);
        return ResponseEntity.ok(hotel1);
    }

    @GetMapping("/getHotelById")
    public ResponseEntity<Hotel> getHotelById(@RequestParam("hotelId") String hotelid) {
        Hotel hotel=hotelService.getHotelById(hotelid);
        return ResponseEntity.ok(hotel);
    }
    @GetMapping("/getAllHotels")
    public ResponseEntity<Iterable<Hotel>> getAllHotels() {
        Iterable<Hotel> hotel=hotelService.getAllHotels();
        return ResponseEntity.ok(hotel);
    }
}
