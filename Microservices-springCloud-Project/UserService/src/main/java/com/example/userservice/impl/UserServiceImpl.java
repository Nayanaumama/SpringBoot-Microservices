package com.example.userservice.impl;

import com.example.userservice.entity.User;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.repo.UserRepository;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        //to generate unique random id globally . Good for microservices .So no id dupication in entire server around globals
        UUID uuid = UUID.randomUUID();
        user.setUserId(uuid.toString());
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id is not present"+" "+userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
