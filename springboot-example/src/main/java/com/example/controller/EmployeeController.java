package com.example.controller;


import com.example.exception.ResourceNotFoundException;
import com.example.models.Employee;
import com.example.daos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // get/retrieve all employees rest api
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // post/create employees rest api
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    // put/update the entire resource of employee column by id
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id , @RequestBody Employee employeeDetails){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()){
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        Employee employee = optionalEmployee.get();
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        return employeeRepository.save(employee);
    }

    // delete employee column by id
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()){
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
        return "Employee deleted successfully with id: " + id;
    }

    // patch/update only specified fields of employee
    @PatchMapping("/employee/{id}")
    public Employee partiallyUpdateEmployee(@PathVariable Long id , @RequestBody Employee employeeDetails){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent()){
            throw new ResourceNotFoundException("employee not found with id"+ id);
        }

        Employee employee = optionalEmployee.get();

        // check each field if non-null and update only if it's provided
        if (employeeDetails.getFirstName() != null){
            employee.setFirstName(employeeDetails.getFirstName());
        } if (employeeDetails.getLastName() != null){
            employee.setLastName(employeeDetails.getLastName());
        } if (employeeDetails.getEmailId() != null){
            employee.setEmailId(employeeDetails.getEmailId());
        }

        return employeeRepository.save(employee);
    }

}

