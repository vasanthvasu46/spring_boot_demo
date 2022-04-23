package com.employeeee.controller;

import com.employeeee.entity.JuniorEmployee;
import com.employeeee.entity.SeniorEmployee;
import com.employeeee.service.JuniorEmployeeService;
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

    //GET all junior employees
    @ApiOperation(value = "Get all juniors under a senior from database", notes = "Returns all juniors details under a senior from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @GetMapping("/senior/{seniorId}/junior")
    public ResponseEntity<List<JuniorEmployee>> getAllJuniorEmployees(@PathVariable int seniorId) {
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeService.getJuniorEmployeesBySeniorID(seniorId).forEach(juniorEmployeeList::add);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }

    //GET junior employee by ID
    @ApiOperation(value = "Get a junior from database under a senior", notes = "Returns a junior details from the database who is under a senior")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @GetMapping("/senior/{seniorId}/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> getJuniorEmployeeById(@ApiParam(
            name = "ID",
            type = "Integer",
            value = "Junior employee ID",
            example = "1",
            required = true) @PathVariable int juniorId) {
        JuniorEmployee juniorEmployee = juniorEmployeeService.getJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.ACCEPTED);
    }

    //ADD junior employee to a senior
    @ApiOperation(value = "Add a junior to a senior", notes = "Add a junior to a senior in database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @PostMapping("/senior/{seniorId}/junior")
    public ResponseEntity<JuniorEmployee> addJuniorEmployee(@RequestBody JuniorEmployee juniorEmployee,
                                                            @ApiParam(
                                                                    name = "ID",
                                                                    type = "Integer",
                                                                    value = "Senior employee ID",
                                                                    example = "1",
                                                                    required = true) @PathVariable int seniorId) {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(seniorId, "", 0,""));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.CREATED);
    }


    //UPDATE junior employee
    @ApiOperation(value = "Update a junior int database", notes = "Update a junior details in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @PutMapping("/senior/{seniorId}/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> addJuniorEmploee(@RequestBody JuniorEmployee juniorEmployee, @ApiParam(
            name = "ID",
            type = "Integer",
            value = "Senior employee ID",
            example = "1",
            required = true) @PathVariable int seniorId) {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(seniorId, "", 0,""));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.OK);
    }


    //DELETE junior employee under a senior by ID
    @ApiOperation(value = "Delete a junior under a senior", notes = "Delete a senior under a senior in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @DeleteMapping("/senior/{seniorId}/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> deleteJuniorEmployeeById(
            @ApiParam(
                    name = "ID",
                    type = "Integer",
                    value = "Junior employee ID",
                    example = "1",
                    required = true)@PathVariable int juniorId) {
        juniorEmployeeService.deleteJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(HttpStatus.OK);
    }


    //GET all juniors
    @ApiOperation(value = "Get all juniors from database", notes = "Returns all juniors details from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @GetMapping("/junior")
    public ResponseEntity<List<JuniorEmployee>> getAllJunior() {
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeService.getAllJunior()
                .forEach(juniorEmployeeList::add);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }


    //GET junior by ID
    @ApiOperation(value = "Get a junior from database", notes = "Returns junior details from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @GetMapping("/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> getByJuniorId(@ApiParam(
            name = "ID",
            type = "Integer",
            value = "Junior employee ID",
            example = "1",
            required = true)@PathVariable int juniorId) {
        JuniorEmployee juniorEmployee = juniorEmployeeService.getJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.ACCEPTED);
    }


    //DELETE a junior by ID
    @ApiOperation(value = "Delete a junior in database", notes = "Delete junior detail in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @DeleteMapping("junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> deleteJuniorById(@ApiParam(
            name = "ID",
            type = "Integer",
            value = "Junior employee ID",
            example = "1",
            required = true)@PathVariable int juniorId) {
        juniorEmployeeService.deleteJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(HttpStatus.OK);
    }

    @GetMapping("/junior/search/{location}")
    public ResponseEntity<List<JuniorEmployee>> getJuniorByLocation(@PathVariable String location)
    {
        List<JuniorEmployee> juniorEmployeeList= juniorEmployeeService.
        getJuniorEmployeeByLocation(location);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }
}
