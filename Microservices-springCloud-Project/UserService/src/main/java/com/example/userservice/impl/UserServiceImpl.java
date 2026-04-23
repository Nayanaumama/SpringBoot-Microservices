package com.example.userservice.impl;

import com.example.userservice.entity.Hotel;
import com.example.userservice.entity.Rating;
import com.example.userservice.entity.User;
import com.example.userservice.exception.ResourceNotFoundException;
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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

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
        String url = "http://localhost:8087/rate/userId?userId=" + userId;

        ResponseEntity<List<Rating>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rating>>() {
                }
        );

        List<Rating> ratingForUser = response.getBody();
        List<Rating> rating = ratingForUser.stream().map(rating1 -> {
            String url2 = "http://localhost:8084/hotel/getHotelById?hotelId=" + rating1.getHotelId();
            ResponseEntity<Hotel> hotel = restTemplate.getForEntity(url2, Hotel.class);
            Hotel hotel1 = hotel.getBody();
            rating1.setHotel(hotel1);
            return rating1;
        }).collect(Collectors.toList());
        user.setRating(ratingForUser);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list1 = userRepository.findAll();
//       String url="http://localhost:8087/rate/all";
//       ArrayList<Rating> ratingForUSer= restTemplate.getForObject(url, ArrayList.class);
//      String userId= ratingForUSer.get(3).getUserId();
//       for( User user:list1)
//           user.setRating(userId);
        return list1;
    }
}