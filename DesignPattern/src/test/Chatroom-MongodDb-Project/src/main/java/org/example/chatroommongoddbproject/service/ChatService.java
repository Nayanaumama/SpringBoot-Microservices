package org.example.chatroommongoddbproject.service;

import org.example.chatroommongoddbproject.exception.ResourceNotFound;
import org.example.chatroommongoddbproject.model.Chatroom;
import org.example.chatroommongoddbproject.model.Message;
import org.example.chatroommongoddbproject.model.User;
import org.example.chatroommongoddbproject.repository.ChatRoomRepository;
import org.example.chatroommongoddbproject.repository.MessageRepository;
import org.example.chatroommongoddbproject.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final MessageRepository messageRepository;

    public ChatService(UserRepository userRepository, ChatRoomRepository chatRoomRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.chatRoomRepository = chatRoomRepository;
        this.messageRepository = messageRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);

    }

    public Chatroom createRoom(Chatroom room) {
        return chatRoomRepository.save(room);
    }

    public Message sendMessage(Message message) {
        Chatroom room = chatRoomRepository.findById(message.getRoomId())
                .orElseThrow(() -> new ResourceNotFound("Room not found with id: " + message.getRoomId() + ""));

        if (!room.getParticipantsId().contains(message.getSenderId())) {
            throw new RuntimeException("User is not part of this room");

        }

        Message message1 = new Message(message.getRoomId(), message.getSenderId(), message.getText());
        return messageRepository.save(message);
    }
}
