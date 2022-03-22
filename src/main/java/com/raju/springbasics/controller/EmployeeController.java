package com.raju.springbasics.controller;

import com.raju.springbasics.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/test")
    public ResponseEntity<Object> testAPI(){
        Employee employee = new Employee("Raju", 24);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
