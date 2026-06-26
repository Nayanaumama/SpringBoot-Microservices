package org.example.chatroommongoddbproject.repository;

import org.example.chatroommongoddbproject.model.Chatroom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<Chatroom,String> {


}
