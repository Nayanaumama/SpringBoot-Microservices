package com.example.rateservice.controller;

import com.example.rateservice.entity.Rating;
import com.example.rateservice.repo.RatingRepo;
import com.example.rateservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {

        Rating rating1=ratingService.createRating(rating);
       return ResponseEntity.ok(rating1);
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<Rating>> getAllRatings(){
        return new ResponseEntity<>(ratingService.getAllRatings(), HttpStatus.OK);

    }
    @GetMapping("/userId")
    public ResponseEntity<List<Rating>> getRatingByUserId(@RequestParam String userId){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.OK);
    }
    @GetMapping("/hotelId")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@RequestParam String hotelId){
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
    }
}
