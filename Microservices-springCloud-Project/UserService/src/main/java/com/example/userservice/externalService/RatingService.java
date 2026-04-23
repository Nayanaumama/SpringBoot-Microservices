package com.example.userservice.externalService;

import com.example.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("rateservice")
public interface RatingService {
    @GetMapping("/rate/all")
    List<Rating> getAllRatings();
}
