package com.Employee.Controller;

import com.Employee.Model.JuniorEmployee;
import com.Employee.Model.SeniorEmployee;
import com.Employee.Service.JuniorEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JuniorEmployeeController {

    @Autowired
    private JuniorEmployeeService juniorEmployeeService;

    @GetMapping("/senior/{se_id}/junior")
    public ResponseEntity<List<JuniorEmployee>> getAllJuniorEmployees(@PathVariable int se_id)
    {
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeService.getAllJuniorEmployees(se_id)
                .forEach(juniorEmployeeList::add);
        return new ResponseEntity<List<JuniorEmployee>>(juniorEmployeeList, HttpStatus.OK);
    }

    @GetMapping("/senior/{se_id}/junior/{je_id}")
    public ResponseEntity<JuniorEmployee> getJuniorEmployeeById(@PathVariable int je_id)
    {
        JuniorEmployee juniorEmployee = juniorEmployeeService.getJuniorEmployeeById(je_id);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.ACCEPTED);
    }

    @PostMapping("/senior/{se_id}/junior")
    public ResponseEntity<JuniorEmployee> addJuniorEmployee(@RequestBody JuniorEmployee juniorEmployee, @PathVariable int se_id)
    {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(se_id,"",""));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/senior/{se_id}/junior/{je_id}")
    public ResponseEntity<JuniorEmployee> addJuniorEmploee(@RequestBody JuniorEmployee juniorEmployee, @PathVariable int se_id)
    {
        juniorEmployee.setSeniorEmployee(new SeniorEmployee(se_id,"",""));
        juniorEmployeeService.addJuniorEmployee(juniorEmployee);
        return new ResponseEntity<JuniorEmployee>(juniorEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/senior/{se_id}/junior/{je_id}")
    public ResponseEntity<JuniorEmployee> deletejuniorEmployeeById(@PathVariable int je_id)
    {
        juniorEmployeeService.deleteJuniorEmployeeById(je_id);
        return new ResponseEntity<JuniorEmployee>(HttpStatus.OK);
    }
}
