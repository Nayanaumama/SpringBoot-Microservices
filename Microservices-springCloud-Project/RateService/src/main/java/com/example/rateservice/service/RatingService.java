package com.example.rateservice.service;

import com.example.rateservice.entity.Rating;

import java.util.List;

public interface RatingService {

    //create Rating
    Rating createRating(Rating rating);

    //Get All the RAtings
    Iterable<Rating> getAllRatings();

    //Get rating by userId
    List<Rating> getRatingByUserId(String userId);

    //Get rating by hotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
