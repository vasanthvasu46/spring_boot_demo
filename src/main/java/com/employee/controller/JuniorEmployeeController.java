package com.employee.controller;

import com.employee.entity.JuniorEmployee;
import com.employee.entity.SeniorEmployee;
import com.employee.service.JuniorEmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class JuniorEmployeeController {

    @Autowired
    private JuniorEmployeeService juniorEmployeeService;

    //GET all juniors
    @ApiOperation(value = "Get all juniors from database", notes = "Returns all juniors details from the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"), @ApiResponse(code = 404, message = "Not found - No record found in database")})
    @GetMapping("/junior")
    public ResponseEntity<List<JuniorEmployee>> getAllJunior() {
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeService.getAllJunior().forEach(juniorEmployeeList::add);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }


    //GET all junior employees
    @ApiOperation(value = "Get all juniors under a senior from database", notes = "Returns all juniors details under a senior from the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"), @ApiResponse(code = 404, message = "Not found - No record found in database")})
    @GetMapping("/senior/{seniorId}/junior")
    public ResponseEntity<List<JuniorEmployee>> getAllJuniorEmployees(@PathVariable int seniorId) {
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeService.getJuniorEmployeesBySeniorID(seniorId).forEach(juniorEmployeeList::add);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }

    //GET junior by ID
    @ApiOperation(value = "Get a junior from database", notes = "Returns junior details from the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"), @ApiResponse(code = 404, message = "Not found - No record found in database")})
    @GetMapping("/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> getByJuniorId(@PathVariable int juniorId) {
        JuniorEmployee juniorEmployee = juniorEmployeeService.getJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.ACCEPTED);
    }

    //ADD junior employee to a senior
    @ApiOperation(value = "Add a junior to a senior", notes = "Add a junior to a senior in database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"), @ApiResponse(code = 404, message = "Not found - No record found in database")})
    @PostMapping("/senior/{seniorId}/junior")
    public ResponseEntity<JuniorEmployee> addJuniorEmployee(@RequestBody JuniorEmployee juniorEmployee, @PathVariable int seniorId) {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(seniorId, "", 0, ""));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.CREATED);
    }


    //UPDATE junior employee
    @ApiOperation(value = "Update a junior int database", notes = "Update a junior details in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"), @ApiResponse(code = 404, message = "Not found - No record found in database")})
    @PutMapping("/senior/{seniorId}/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> addJuniorEmploee(@RequestBody JuniorEmployee juniorEmployee, @PathVariable int seniorId) {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(seniorId, "", 0, ""));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.OK);
    }

    //DELETE a junior by ID
    @ApiOperation(value = "Delete a junior in database", notes = "Delete junior detail in the database")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"), @ApiResponse(code = 404, message = "Not found - No record found in database")})
    @DeleteMapping("junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> deleteJuniorById(@PathVariable int juniorId) {
        juniorEmployeeService.deleteJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(HttpStatus.OK);
    }

    @ApiOperation(value = "Get Junior based on location", notes = "Get junior based on the location given as input")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved"), @ApiResponse(code = 404, message = "Not found - No record found with given location")})
    @GetMapping("/junior/search/{location}")
    public ResponseEntity<List<JuniorEmployee>> getJuniorByLocation(@PathVariable String location) {
        List<JuniorEmployee> juniorEmployeeList = juniorEmployeeService.getJuniorEmployeeByLocation(location);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }
}
