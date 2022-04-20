package com.Employee.Controller;

import com.Employee.Model.SeniorEmployee;
import com.Employee.Service.SeniorEmployeeService;
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

    @GetMapping("/senior/{se_id}")
    public ResponseEntity<SeniorEmployee> getSeniorEmployeeById(@PathVariable int se_id) {
        SeniorEmployee seniorEmployee = seniorEmployeeService.getSeniorEmployeeById(se_id);
        return new ResponseEntity<SeniorEmployee>(seniorEmployee, HttpStatus.OK);
    }

    @PostMapping("/senior")
    public ResponseEntity<SeniorEmployee> addSeniorEmployee(@RequestBody SeniorEmployee seniorEmployee) {
        seniorEmployeeService.addSeniorEmployee(seniorEmployee);
        return new ResponseEntity<SeniorEmployee>(seniorEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/senior/{se_id}")
    public ResponseEntity<SeniorEmployee> updateSeniorEmployeeById(@RequestBody SeniorEmployee seniorEmployee, @PathVariable int se_id) {
        seniorEmployeeService.addSeniorEmployee(seniorEmployee);
        return new ResponseEntity<SeniorEmployee>(seniorEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/senior/{se_id}")
    public ResponseEntity<String> deleteSeniorEmployee(@PathVariable int se_id) {
        seniorEmployeeService.deleteSeniorEmployeeById(se_id);
        return new ResponseEntity<String>("DELETED", HttpStatus.OK);
    }

    @GetMapping("/senior/find/{job_role}")
    public ResponseEntity<List<SeniorEmployee>> getSeniorEmployeeByJobRole(@PathVariable String job_role) {
        List<SeniorEmployee> employeeList = seniorEmployeeService.getSeniorEmployeeByJobRole(job_role);
        return new ResponseEntity<List<SeniorEmployee>>(employeeList, HttpStatus.OK);
    }
}
