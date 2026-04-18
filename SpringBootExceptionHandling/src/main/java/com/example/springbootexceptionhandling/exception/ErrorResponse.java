package com.example.springbootexceptionhandling.exception;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorResponse {
    LocalDateTime timestamp;
    String message;

    public ErrorResponse(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp.toLocalDate().atStartOfDay();
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }

    public ErrorResponse() {
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp.toLocalDate().atStartOfDay();
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

