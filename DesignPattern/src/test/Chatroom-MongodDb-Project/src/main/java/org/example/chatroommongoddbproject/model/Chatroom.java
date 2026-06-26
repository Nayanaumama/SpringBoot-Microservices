package org.example.chatroommongoddbproject.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Chatroom {

    private String id;
    private String chatrooName;
    private List<String> participantsId;


    public Chatroom(String id, String chatrooName, List<String> participantsId) {
        this.id = id;
        this.chatrooName = chatrooName;
        this.participantsId = participantsId;
    }

    public Chatroom() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatrooName() {
        return chatrooName;
    }

    public void setChatrooName(String chatrooName) {
        this.chatrooName = chatrooName;
    }

    public List<String> getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(List<String> participantsId) {
        this.participantsId = participantsId;
    }
}
