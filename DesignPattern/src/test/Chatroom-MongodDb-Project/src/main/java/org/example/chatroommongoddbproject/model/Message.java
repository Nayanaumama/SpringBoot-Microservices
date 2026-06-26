package org.example.chatroommongoddbproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Message {

    @Id
    private String id;
    private String roomId;
    private String senderId;
    private String text;
    private LocalDateTime sentAt;

    public Message() {
    }
    public Message(String id, String roomId, String senderId, String text, LocalDateTime sentAt) {
        this.id = id;
        this.roomId = roomId;
        this.senderId = senderId;
        this.text = text;
        this.sentAt = sentAt;
    }

    public Message(String roomId, String senderId, String text) {
        this.roomId = roomId;
        this.senderId = senderId;
        this.text = text;
        this.sentAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
