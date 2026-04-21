package com.example.userservice.service;

import com.example.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User saveUser(User user);
    User getUser(String userId);
    List<User> getAllUsers();
}
