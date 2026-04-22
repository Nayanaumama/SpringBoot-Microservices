package com.example.rateservice.impl;

import com.example.rateservice.entity.Rating;
import com.example.rateservice.repo.RatingRepo;
import com.example.rateservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImp implements RatingService {

    @Autowired
   private  RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
        UUID uuid = UUID.randomUUID();
        rating.setRatingId(uuid.toString());
        return ratingRepo.save(rating);
    }

    @Override
    public Iterable<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);

    }
}
