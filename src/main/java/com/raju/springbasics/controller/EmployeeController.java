package com.raju.springbasics.controller;

import com.raju.springbasics.model.Employee;
import com.raju.springbasics.service.EmployeeService;
import com.raju.springbasics.service.IEmpService;
import com.raju.springbasics.service.NewEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    // Singleton pattern & Inversion of Control
    @Autowired
    IEmpService employeeService;

    // JSON Marshalling & UnMarshalling
    @GetMapping("/employee")
    public ResponseEntity<Object> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployeeDetails(),HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        final boolean isAdded = employeeService.createEmployee(employee);
        Map<String, Object> response = new HashMap<>();
        response.put("isCreated", isAdded);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/employee")
    public ResponseEntity<Object> deleteEmployee(@RequestParam String id){
        final boolean isDeleted = employeeService.deleteEmployee(id);

        Map<String, Object> response = new HashMap<>();
        response.put("isDeleted", isDeleted);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
