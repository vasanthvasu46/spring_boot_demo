package com.employee.controller;

import com.employee.entity.JuniorEmployee;
import com.employee.entity.SeniorEmployee;
import com.employee.service.JuniorEmployeeService;
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

    @GetMapping("/senior/{seniorId}/junior")
    public ResponseEntity<List<JuniorEmployee>> getAllJuniorEmployees(@PathVariable int seniorId) {
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeService.getAllJuniorEmployees(seniorId).forEach(juniorEmployeeList::add);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }

    @GetMapping("/senior/{seniorId}/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> getJuniorEmployeeById(@PathVariable int juniorId) {
        JuniorEmployee juniorEmployee = juniorEmployeeService.getJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.ACCEPTED);
    }

    @PostMapping("/senior/{seniorId}/junior")
    public ResponseEntity<JuniorEmployee> addJuniorEmployee(@RequestBody JuniorEmployee juniorEmployee, @PathVariable int seniorId) {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(seniorId, "", "", 0));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/senior/{seniorId}/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> addJuniorEmploee(@RequestBody JuniorEmployee juniorEmployee, @PathVariable int seniorId) {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(seniorId, "", "", 0));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/senior/{seniorId}/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> deleteJuniorEmployeeById(@PathVariable int juniorId) {
        juniorEmployeeService.deleteJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(HttpStatus.OK);
    }

    @GetMapping("/junior")
    public ResponseEntity<List<JuniorEmployee>> getAllJunior() {
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeService.getAllJunior()
                .forEach(juniorEmployeeList::add);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }

    @GetMapping("/junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> getByJuniorId(@PathVariable int juniorId) {
        JuniorEmployee juniorEmployee = juniorEmployeeService.getJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("junior/{juniorId}")
    public ResponseEntity<JuniorEmployee> deleteJuniorById(@PathVariable int juniorId) {
        juniorEmployeeService.deleteJuniorEmployeeById(juniorId);
        return new ResponseEntity<JuniorEmployee>(HttpStatus.OK);
    }
}
