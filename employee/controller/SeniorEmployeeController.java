package com.employee.controller;

import com.employee.entity.SeniorEmployee;
import com.employee.service.SeniorEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class SeniorEmployeeController {

    @Autowired
    private SeniorEmployeeService seniorEmployeeService;

    @GetMapping("/senior")
    public ResponseEntity<List<SeniorEmployee>> getAllSeniorEmployees() {
        List<SeniorEmployee> seniorEmployeeList = seniorEmployeeService.getAllSeniorEmployees();
        return new ResponseEntity<List<SeniorEmployee>>(seniorEmployeeList, HttpStatus.OK);
    }

    @GetMapping("/senior/{seniorId}")
    public ResponseEntity<SeniorEmployee> getSeniorEmployeeById(@PathVariable int seniorId) {
        SeniorEmployee seniorEmployee = seniorEmployeeService.getSeniorEmployeeById(seniorId);
        return new ResponseEntity<SeniorEmployee>(seniorEmployee, HttpStatus.OK);
    }

    @PostMapping("/senior")
    public ResponseEntity<SeniorEmployee> addSeniorEmployee(@RequestBody SeniorEmployee seniorEmployee) {
        seniorEmployeeService.addSeniorEmployee(seniorEmployee);
        return new ResponseEntity<SeniorEmployee>(seniorEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/senior/{seniorId}")
    public ResponseEntity<SeniorEmployee> updateSeniorEmployeeById(@RequestBody SeniorEmployee seniorEmployee, @PathVariable int seniorId) {
        seniorEmployeeService.addSeniorEmployee(seniorEmployee);
        return new ResponseEntity<SeniorEmployee>(seniorEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/senior/{seniorId}")
    public ResponseEntity<String> deleteSeniorEmployee(@PathVariable int seniorId) {
        seniorEmployeeService.deleteSeniorEmployeeById(seniorId);
        return new ResponseEntity<String>("DELETED", HttpStatus.OK);
    }

    @GetMapping("/senior/find/{jobRole}")
    public ResponseEntity<List<SeniorEmployee>> getSeniorEmployeeByJobRole(@PathVariable String jobRole) {
        List<SeniorEmployee> employeeList = seniorEmployeeService.getSeniorEmployeeByJobRole(jobRole);
        return new ResponseEntity<List<SeniorEmployee>>(employeeList, HttpStatus.OK);
    }
}
