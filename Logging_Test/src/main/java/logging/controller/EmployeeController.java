package logging.controller;

import logging.entity.Employee;
import logging.service.EmployeeService;
import logging.entity.Employee;
import logging.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/senior")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> seniorEmployeeList = employeeService.getAllEmployees();

        log.debug("List of students displayed");

        return new ResponseEntity<List<Employee>>(seniorEmployeeList, HttpStatus.OK);
    }

    @GetMapping("/senior/{se_id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int se_id)
    {
        Employee seniorEmployee = employeeService.getEmployeeById(se_id);

        log.debug("Student with given id displayed");

        return new ResponseEntity<Employee>(seniorEmployee,HttpStatus.ACCEPTED);
    }

    @PostMapping("/senior")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee seniorEmployee)
    {
        employeeService.addEmployee(seniorEmployee);

        log.debug("Added student to DB");

        return new ResponseEntity<Employee>(seniorEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/senior/{se_id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee seniorEmployee,@PathVariable int se_id)
    {
        employeeService.addEmployee(seniorEmployee);

        log.debug("Updated student in DB");

        return new ResponseEntity<Employee>(seniorEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/senior/{se_id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int se_id)
    {
        employeeService.deleteEmployeeById(se_id);

        log.debug("Deleted student from DB");

        return new ResponseEntity<Employee>(HttpStatus.OK);
    }


}
