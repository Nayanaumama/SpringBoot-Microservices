package com.example.userservice.impl;

import com.example.userservice.entity.Hotel;
import com.example.userservice.entity.Rating;
import com.example.userservice.entity.User;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.externalService.HotelService;
import com.example.userservice.externalService.RatingService;
import com.example.userservice.repo.UserRepository;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;
    @Autowired
    RatingService ratingService;

    @Override
    public User saveUser(User user) {
        //to generate unique random id globally . Good for microservices .So no id dupication in entire server around globals
        UUID uuid = UUID.randomUUID();
        user.setUserId(uuid.toString());
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        //lets get the rating for this user from the rating service using http API communication
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not present" + " " + userId));
        String url = "http://RATESERVICE/rate/userId?userId=" + userId;

        ResponseEntity<List<Rating>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rating>>() {
                }
        );
        List<Rating> ratingForUser = response.getBody();
        //using feign client to get hotel details for the userId
        List<Rating> rating = ratingForUser.stream().map(rating1 -> {
            Hotel hotel = hotelService.getHotelById(rating1.getHotelId());
            rating1.setHotel(hotel);
            return rating1;
        }).collect(Collectors.toList());
        user.setRating(ratingForUser);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
//Feign client usage
        List<Rating> ratings = ratingService.getAllRatings();

        for (Rating rating : ratings) {
            Hotel hotel = hotelService.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
        }

        Map<String, List<Rating>> ratingsByUserId = ratings.stream()
                .collect(Collectors.groupingBy(Rating::getUserId));

        for (User user : users) {
            user.setRating(ratingsByUserId.getOrDefault(user.getUserId(), new ArrayList<>()));
        }

        return users;
    }
}
