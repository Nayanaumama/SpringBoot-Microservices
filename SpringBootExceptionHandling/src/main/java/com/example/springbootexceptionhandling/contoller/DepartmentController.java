package com.example.springbootexceptionhandling.contoller;

import com.example.springbootexceptionhandling.exception.EmployeeNotFoundException;
import com.example.springbootexceptionhandling.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    List<Employee> employees = List.of(new Employee(1, "Nayana", 20000));
    @GetMapping("/department/{id}")

    public ResponseEntity<?> getEmployeesById(@PathVariable int id) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return new ResponseEntity<>(employee, HttpStatus.CREATED);
            }
        }
        throw new EmployeeNotFoundException("Employee not found");


    }
}
