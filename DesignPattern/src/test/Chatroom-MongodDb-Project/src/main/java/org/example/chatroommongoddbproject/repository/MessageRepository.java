package org.example.chatroommongoddbproject.repository;

import org.example.chatroommongoddbproject.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message,String> {
}
