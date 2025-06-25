package com.example.controller;


import com.example.models.Employee;
import com.example.daos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees rest api

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}

