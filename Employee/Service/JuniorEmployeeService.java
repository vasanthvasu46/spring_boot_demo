package com.Employee.Service;

import com.Employee.CustomException.EmptyDBExceptionClass;
import com.Employee.CustomException.EmptyFieldException;
import com.Employee.Model.JuniorEmployee;
import com.Employee.Model.SeniorEmployee;
import com.Employee.Repository.JuniorEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JuniorEmployeeService {

    @Autowired
    private JuniorEmployeeRepository juniorEmployeeRepository;

    public List<JuniorEmployee> getAllJuniorEmployees(int se_id) {
        List<JuniorEmployee> juniorEmployeesList = new ArrayList<>();
        juniorEmployeeRepository.findBySeniorEmployeeId(se_id).forEach(juniorEmployeesList::add);

        if (juniorEmployeesList.isEmpty()) {
            throw new EmptyDBExceptionClass("601", "No records found in DB");
        }

        return juniorEmployeesList;
    }

    public JuniorEmployee getJuniorEmployeeById(int je_id) {
        Optional<JuniorEmployee> juniorEmployee = juniorEmployeeRepository.findById(je_id);
        if (!juniorEmployee.isPresent()) {
            throw new NoSuchElementException("No Resource found with given id : " + je_id);
        }

        JuniorEmployee junior = juniorEmployee.get();
        return junior;
    }

    public JuniorEmployee addJuniorEmployee(JuniorEmployee juniorEmployee) {

        if (juniorEmployee.getName().isEmpty()) {
            throw new EmptyFieldException("602", "Name field is empty.");
        }
        if (juniorEmployee.getJob_role().isEmpty()) {
            throw new EmptyFieldException("603", "Job role field is empty");
        }
        juniorEmployeeRepository.save(juniorEmployee);
        return juniorEmployee;
    }

    public void deleteJuniorEmployeeById(int je_id) {

        Optional<JuniorEmployee> juniorEmployee = juniorEmployeeRepository.findById(je_id);
        if (!juniorEmployee.isPresent()) {
            throw new NoSuchElementException("No resource found with given id : " + je_id);
        }
        JuniorEmployee junior = juniorEmployee.get();
        juniorEmployeeRepository.delete(junior);
    }

    public List<JuniorEmployee> getAllJunior() {
        List<JuniorEmployee> juniorEmployeesList = new ArrayList<>();
        juniorEmployeeRepository.findAll().forEach(juniorEmployeesList::add);

        if (juniorEmployeesList.isEmpty()) {
            throw new EmptyDBExceptionClass("601", "No records round in DB");
        }
        return juniorEmployeesList;
    }

    public JuniorEmployee getByJuniorId(int je_id) {
        Optional<JuniorEmployee> juniorEmployee = juniorEmployeeRepository.findById(je_id);
        if (!juniorEmployee.isPresent()) {
            throw new NoSuchElementException("No Resource found with given id : " + je_id);
        }

        JuniorEmployee junior = juniorEmployee.get();
        return junior;
    }
}
