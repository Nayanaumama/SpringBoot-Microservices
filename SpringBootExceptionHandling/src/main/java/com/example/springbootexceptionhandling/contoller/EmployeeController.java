package com.example.springbootexceptionhandling.contoller;

import com.example.springbootexceptionhandling.exception.EmployeeNotFoundException;
import com.example.springbootexceptionhandling.exception.ErrorResponse;
import com.example.springbootexceptionhandling.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {

    List<Employee> employees = List.of(new Employee(1, "Nayana", 20000), new Employee(2, "Geetha", 25000));

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeesById(@PathVariable int id) {

            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    return new ResponseEntity<>(employee, HttpStatus.CREATED);
                }
            }
            throw new EmployeeNotFoundException("Employee not found");


        }



    @GetMapping("/employees/name/{name}")
    public ResponseEntity<?> getEmplyoyyesByName(@PathVariable String name) {
        {
            for (Employee employee : employees) {
                if (Objects.equals(employee.getName(), name)) {
                    return new ResponseEntity<>(employee, HttpStatus.FOUND);
                }
            }
            throw new EmployeeNotFoundException("Employee not found");
        }

    }


    }
