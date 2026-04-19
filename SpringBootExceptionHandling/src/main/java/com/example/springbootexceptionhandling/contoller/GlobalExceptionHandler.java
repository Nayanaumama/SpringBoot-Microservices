package com.example.springbootexceptionhandling.contoller;

import com.example.springbootexceptionhandling.exception.EmployeeNotFoundException;
import com.example.springbootexceptionhandling.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> employeeNotFoundExcpetionhandler(EmployeeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), "Employee not found");
        ResponseEntity.notFound().build();
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }
}
