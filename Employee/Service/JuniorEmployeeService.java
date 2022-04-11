package com.Employee.Service;

import com.Employee.Model.JuniorEmployee;
import com.Employee.Repository.JuniorEmployeeRepository;
import com.Employee.Repository.JuniorEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JuniorEmployeeService {

    @Autowired
    private JuniorEmployeeRepository juniorEmployeeRepository;

    public List<JuniorEmployee> getAllJuniorEmployees(int se_id)
    {
        List<JuniorEmployee> juniorEmployeesList = new ArrayList<>();
        juniorEmployeeRepository.findBySeniorEmployeeId(se_id).forEach(juniorEmployeesList::add);
        return juniorEmployeesList;
    }

    public JuniorEmployee getJuniorEmployeeById(int je_id)
    {
        JuniorEmployee juniorEmployee = juniorEmployeeRepository.findById(je_id).get();
        return juniorEmployee;
    }

    public JuniorEmployee addJuniorEmployee(JuniorEmployee juniorEmployee)
    {
        juniorEmployeeRepository.save(juniorEmployee);
        return juniorEmployee;
    }

    public void deleteJuniorEmployeeById(int je_id)
    {
        juniorEmployeeRepository.deleteById(je_id);
    }
}
