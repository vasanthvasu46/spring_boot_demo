package com.employee.controller;

import com.employee.entity.SeniorEmployee;
import com.employee.service.SeniorEmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    //GET All seniors
    @ApiOperation(value = "Get all seniors from database", notes = "Returns all seniors details from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @GetMapping("/senior")
    public ResponseEntity<List<SeniorEmployee>> getAllSeniorEmployees() {
        List<SeniorEmployee> seniorEmployeeList = seniorEmployeeService.getAllSeniorEmployees();
        return new ResponseEntity<List<SeniorEmployee>>(seniorEmployeeList, HttpStatus.OK);
    }

    //GET senior employee by ID
    @ApiOperation(value = "Get a senior from database", notes = "Returns a senior details from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @GetMapping("/senior/{seniorId}")
    public ResponseEntity<SeniorEmployee> getSeniorEmployeeById(@ApiParam(
            name = "ID",
            type = "Integer",
            value = "Senior Employee ID",
            example = "1",
            required = true) @PathVariable int seniorId) {
        SeniorEmployee seniorEmployee = seniorEmployeeService.getSeniorEmployeeById(seniorId);
        return new ResponseEntity<SeniorEmployee>(seniorEmployee, HttpStatus.OK);
    }


    //ADD senior employee
    @ApiOperation(value = "Add a senior to database", notes = "Add a senior to database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @PostMapping("/senior")
    public ResponseEntity<String> addSeniorEmployee(@RequestBody SeniorEmployee seniorEmployee) {
        seniorEmployeeService.addSeniorEmployee(seniorEmployee);
        return new ResponseEntity<String>("Added Senior Employee", HttpStatus.CREATED);
    }


    //UPDATE senior employee
    @ApiOperation(value = "Update a senior int database", notes = "Update a senior details in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @PutMapping("/senior/{seniorId}")
    public ResponseEntity<String> updateSeniorEmployeeById(@RequestBody SeniorEmployee seniorEmployee, @PathVariable int seniorId) {
        seniorEmployeeService.addSeniorEmployee(seniorEmployee);
        return new ResponseEntity<String>("Updated Senior Employee with id :" + seniorId, HttpStatus.OK);
    }


    //DELETE senior employee
    @ApiOperation(value = "Delete a senior in database", notes = "Delete senior detail in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @DeleteMapping("/senior/{seniorId}")
    public ResponseEntity<String> deleteSeniorEmployee(@ApiParam(
            name = "ID",
            type = "Integer",
            value = "Senior employee ID",
            example = "1",
            required = true) @PathVariable int seniorId) {
        seniorEmployeeService.deleteSeniorEmployeeById(seniorId);
        return new ResponseEntity<String>("DELETED", HttpStatus.OK);
    }

    @GetMapping("/senior/search/{location}")
    public ResponseEntity<List<SeniorEmployee>> getSeniorByLocation(@PathVariable String location)
    {
        List<SeniorEmployee> seniorEmployeeList= seniorEmployeeService.getSeniorEmployeeByLocation(location);
        return new ResponseEntity<List<SeniorEmployee>>(seniorEmployeeList, HttpStatus.OK);
    }
}
