package com.example.oauthsecurity.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/hello")
        public    String getHEllo()
    {
        return "Hello";
    }

}
