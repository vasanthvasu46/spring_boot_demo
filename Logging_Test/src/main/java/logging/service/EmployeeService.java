package logging.service;


import logging.entity.Employee;
import logging.repository.EmployeeRepository;
import logging.entity.Employee;
import logging.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository seniorEmployeeRepository;

    public List<Employee> getAllEmployees()
    {
        List<Employee> seniorEmployeesList = new ArrayList<>();
        seniorEmployeeRepository.findAll().forEach(seniorEmployeesList::add);

        return seniorEmployeesList;
    }

    public Employee getEmployeeById(int se_id)
    {
        Employee seniorEmployee = seniorEmployeeRepository.findById(se_id).get();

        return seniorEmployee;
    }

    public Employee addEmployee(Employee seniorEmployee)
    {

        seniorEmployeeRepository.save(seniorEmployee);
        return seniorEmployee;
    }



    public void deleteEmployeeById(int se_id)
    {

        seniorEmployeeRepository.deleteById(se_id);

    }

}
