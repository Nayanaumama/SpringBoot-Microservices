package com.example.hotelservice.exception;

import com.example.hotelservice.entity.Hotel;
import com.example.hotelservice.payLoad.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?>resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
    {
        ApiResponse apiResponse= ApiResponse.builder().message(ex.getMessage()).build();
return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
