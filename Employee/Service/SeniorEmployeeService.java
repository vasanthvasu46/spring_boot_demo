package com.Employee.Service;

import com.Employee.CustomException.EmptyDBExceptionClass;
import com.Employee.CustomException.EmptyFieldException;
import com.Employee.Model.SeniorEmployee;
import com.Employee.Repository.SeniorEmployeeRepository;
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

    public List<SeniorEmployee> getAllSeniorEmployees() {
        List<SeniorEmployee> seniorEmployeesList = new ArrayList<>();
        seniorEmployeeRepository.findAll().forEach(seniorEmployeesList::add);

        if (seniorEmployeesList.isEmpty()) {
            throw new EmptyDBExceptionClass("601", "No records found in DB");
        }

        return seniorEmployeesList;
    }

    public SeniorEmployee getSeniorEmployeeById(int se_id) {
        Optional<SeniorEmployee> option = seniorEmployeeRepository.findById(se_id);
        if (!option.isPresent()) {
            throw new NoSuchElementException("No Resource found with given id");
        }
        SeniorEmployee seniorEmployee = option.get();
        return seniorEmployee;
    }

    public SeniorEmployee addSeniorEmployee(SeniorEmployee seniorEmployee) {
        if (seniorEmployee.getName().isEmpty() || seniorEmployee.getName().length() == 0) {
            throw new EmptyFieldException("602", "Name field is empty.");
        }
        if (seniorEmployee.getJob_role().isEmpty() || seniorEmployee.getJob_role().length() == 0) {
            throw new EmptyFieldException("603", "Job role field is empty");
        }
        if (seniorEmployee.getSalary() == 0) {
            throw new EmptyFieldException("603", "Salary field is empty");
        }
        seniorEmployeeRepository.save(seniorEmployee);
        return seniorEmployee;
    }


    public void deleteSeniorEmployeeById(int se_id) {

        Optional<SeniorEmployee> option = seniorEmployeeRepository.findById(se_id);
        if (!option.isPresent()) {
            throw new NoSuchElementException("No Resource found with given id");
        }
        SeniorEmployee seniorEmployee = option.get();
        seniorEmployeeRepository.delete(seniorEmployee);

    }

    public List<SeniorEmployee> getSeniorEmployeeByJobRole(String job_role) {
        List<SeniorEmployee> employeeList = new ArrayList<>();
        seniorEmployeeRepository.getSeniorEmployeeByJobRole(job_role).forEach(employeeList::add);
        return employeeList;
    }
}
