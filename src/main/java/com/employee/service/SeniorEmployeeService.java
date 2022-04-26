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

    public SeniorEmployee getSeniorEmployeeById(int seniorId) {
        Optional<SeniorEmployee> option = seniorEmployeeRepository.findById(seniorId);
        if (!option.isPresent()) {
            log.error("Exception in getSeniorEmployeeById() method");
            throw new NoSuchElementException("No Resource found with given id :" + seniorId);
        }
        SeniorEmployee seniorEmployee = option.get();
        return seniorEmployee;
    }

    public SeniorEmployee addSeniorEmployee(SeniorEmployee seniorEmployee) {
        if (seniorEmployee.getName().isEmpty()) {
            log.error("Exception in addSeniorEmployee() method");
            throw new EmptyFieldException("602", "Name field is empty.");
        }
        if (seniorEmployee.getLocation().isEmpty()) {
            log.error("Exception in addSeniorEmployee() method");
            throw new EmptyFieldException("602", "Location field is empty");
        }
        if (seniorEmployee.getSalary() == 0) {
            log.error("Exception in addSeniorEmployee() method");
            throw new EmptyFieldException("602", "Salary field is empty");
        }
        seniorEmployeeRepository.save(seniorEmployee);
        return seniorEmployee;
    }


    public void deleteSeniorEmployeeById(int seniorId) {

        Optional<SeniorEmployee> option = seniorEmployeeRepository.findById(seniorId);
        if (!option.isPresent()) {
            log.error("Exception in deleteSeniorEmployeeById() method");
            throw new NoSuchElementException("No Resource found with given id");
        }
        SeniorEmployee seniorEmployee = option.get();
        seniorEmployeeRepository.delete(seniorEmployee);

    }

    public List<SeniorEmployee> getSeniorEmployeeByLocation(String location) {
        List<SeniorEmployee> seniorEmployeeList = new ArrayList<>();
        seniorEmployeeRepository.getSeniorEmployeeByLocation(location).forEach(seniorEmployeeList::add);
        if (seniorEmployeeList.isEmpty()) {
            throw new NoSuchElementException("No resource found with given location");
        }
        return seniorEmployeeList;
    }

}
