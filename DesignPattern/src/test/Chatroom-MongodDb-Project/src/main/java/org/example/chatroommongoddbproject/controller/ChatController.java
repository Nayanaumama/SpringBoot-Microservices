package org.example.chatroommongoddbproject.controller;

import org.example.chatroommongoddbproject.model.Chatroom;
import org.example.chatroommongoddbproject.model.Message;
import org.example.chatroommongoddbproject.model.User;
import org.example.chatroommongoddbproject.repository.ChatRoomRepository;
import org.example.chatroommongoddbproject.service.ChatService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat/api")
public class ChatController {

    private final ChatService services;

    public ChatController(ChatService services) {
        this.services = services;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1=services.createUser(user);
        return new ResponseEntity<User>(user1,HttpStatusCode.valueOf(200));

    }

    @PostMapping("/rooms")
    public ResponseEntity<Chatroom> createRoom(@RequestBody Chatroom room) {
        Chatroom chatroom=services.createRoom(room);
        return new ResponseEntity<>(chatroom,HttpStatusCode.valueOf(200));
    }

    @PostMapping("/messages")
    public  ResponseEntity<Message> sendMessage(@RequestBody Message message)
    {
        Message message1=services.sendMessage(message);
        return new ResponseEntity<>(message1,HttpStatusCode.valueOf(200));
    }
}
