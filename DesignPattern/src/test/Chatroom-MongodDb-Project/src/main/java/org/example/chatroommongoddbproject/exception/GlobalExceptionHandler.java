package org.example.chatroommongoddbproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResponseBody> handleResourceNotFound( ) {
      ResponseBody responseBody=new ResponseBody(404,"Resource not found","Resource not found", LocalDateTime.now());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);-->These are all static method of the ResponseEntity
        //return ResponseEntity.ok(e);
       // new ResponseEntity<>(e,HttpStatus.NOT_FOUND);->using Constructor
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();-->this is for when you dont want to return body .just sattus


    }
}
