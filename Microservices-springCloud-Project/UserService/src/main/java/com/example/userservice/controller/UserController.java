package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/save")
    ResponseEntity<User> createUser(@RequestBody User user)
    {
       User user1 = userServiceImpl.saveUser(user);
       return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    @CircuitBreaker(name = "getUserCallingRateAndHotel", fallbackMethod = "getUserFallback")
    ResponseEntity<User> getUser(@RequestParam("userId") String userId)
    {
        User user1= userServiceImpl.getUser(userId);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    ResponseEntity<List<User>> getAllUsers()
    {
        List<User> userList= userServiceImpl.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserFallback(String userId, Exception ex) {

        User user=User.builder().userId(userId).name("").about("Service is down").email("dummy@dummy.com").build();
        return new ResponseEntity<>(user,HttpStatus.SERVICE_UNAVAILABLE);
    }
}
