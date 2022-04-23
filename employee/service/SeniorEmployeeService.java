package com.employee.service;

import com.employee.customexception.EmptyDBException;
import com.employee.customexception.EmptyFieldException;
import com.employee.entity.SeniorEmployee;
import com.employee.repository.SeniorEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SeniorEmployeeService {

    @Autowired
    private SeniorEmployeeRepository seniorEmployeeRepository;

    Logger log = LoggerFactory.getLogger(SeniorEmployeeService.class);


    public List<SeniorEmployee> getAllSeniorEmployees() {
        List<SeniorEmployee> seniorEmployeesList = new ArrayList<>();
        seniorEmployeeRepository.findAll().forEach(seniorEmployeesList::add);

        if (seniorEmployeesList.isEmpty()) {
            log.error("Exception in getAllSeniorEmployees() method");
            throw new EmptyDBException("601", "No records found in DB");
        }

        return seniorEmployeesList;
    }

    public SeniorEmployee getSeniorEmployeeById(int se_id) {
        Optional<SeniorEmployee> option = seniorEmployeeRepository.findById(se_id);
        if (!option.isPresent()) {
            log.error("Exception in getSeniorEmployeeById() method");
            throw new NoSuchElementException("No Resource found with given id");
        }
        SeniorEmployee seniorEmployee = option.get();
        return seniorEmployee;
    }

    public SeniorEmployee addSeniorEmployee(SeniorEmployee seniorEmployee) {
        if (seniorEmployee.getName().isEmpty() || seniorEmployee.getName().length() == 0) {
            log.error("Exception in addSeniorEmployee() method");
            throw new EmptyFieldException("602", "Name field is empty.");
        }
        if (seniorEmployee.getJob_role().isEmpty() || seniorEmployee.getJob_role().length() == 0) {
            log.error("Exception in addSeniorEmployee() method");
            throw new EmptyFieldException("603", "Job role field is empty");
        }
        if (seniorEmployee.getSalary() == 0) {
            log.error("Exception in addSeniorEmployee() method");
            throw new EmptyFieldException("603", "Salary field is empty");
        }
        seniorEmployeeRepository.save(seniorEmployee);
        return seniorEmployee;
    }


    public void deleteSeniorEmployeeById(int se_id) {

        Optional<SeniorEmployee> option = seniorEmployeeRepository.findById(se_id);
        if (!option.isPresent()) {
            log.error("Exception in deleteSeniorEmployeeById() method");
            throw new NoSuchElementException("No Resource found with given id");
        }
        SeniorEmployee seniorEmployee = option.get();
        seniorEmployeeRepository.delete(seniorEmployee);

    }

    public List<SeniorEmployee> getSeniorEmployeeByJobRole(String job_role) {
        List<SeniorEmployee> employeeList = new ArrayList<>();
        seniorEmployeeRepository.getSeniorEmployeeByJobRole(job_role).forEach(employeeList::add);
        if (employeeList.isEmpty()) {
            throw new NoSuchElementException("No employee found with given job role.");
        }
        return employeeList;
    }
}
