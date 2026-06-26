package org.example.chatroommongoddbproject.exception;

import java.time.LocalDateTime;

public record ResponseBody (
    int status,
    String error,
    String message,
    LocalDateTime timestamp)
{

}
