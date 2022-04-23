package com.employee.test;


import com.employee.entity.JuniorEmployee;
import com.employee.repository.JuniorEmployeeRepository;
import com.employee.service.JuniorEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JuniorEmployeeTesterClass {

    @Autowired
    private JuniorEmployeeService juniorEmployeeService;

    @MockBean
    private JuniorEmployeeRepository juniorEmployeeRepository;

    @Test
    public void getJuniorEmployeesBySeniorIDTest()
    {
        List<JuniorEmployee> juniorEmployeeList=new ArrayList<>();
        JuniorEmployee je=new JuniorEmployee();
        je.setId(1);
        je.setName("vasanth");
        je.setJobRole("Intern");
        juniorEmployeeList.add(je);
        when(juniorEmployeeRepository.findBySeniorEmployeeId(1))
                .thenReturn(juniorEmployeeList);

        assertEquals(1,juniorEmployeeService.getJuniorEmployeesBySeniorID(1).size());
    }

    @Test
    public void addJuniorEmployeeTest()
    {
        JuniorEmployee je=new JuniorEmployee();
        je.setId(1);
        je.setName("vasanth");
        je.setJobRole("Intern");
        when(juniorEmployeeRepository.save(je)).thenReturn(je);
        assertEquals(je,juniorEmployeeService.addJuniorEmployee(je));
    }

    @Test
    public void deleteJuniorEmployeeByIdTest()
    {
        JuniorEmployee je=new JuniorEmployee();
        je.setId(1);
        je.setName("vasanth");
        je.setJobRole("Intern");
        when(juniorEmployeeRepository.findById(1)).thenReturn(Optional.of(je));
        juniorEmployeeService.deleteJuniorEmployeeById(1);
        verify(juniorEmployeeRepository,times(1)).delete(je);
    }

    @Test
    public void getAllJuniorTest()
    {
        List<JuniorEmployee> juniorEmployeeList=new ArrayList<>();
        JuniorEmployee je=new JuniorEmployee();
        je.setId(1);
        je.setName("vasanth");
        je.setJobRole("Intern");
        JuniorEmployee je1=new JuniorEmployee();
        je1.setId(2);
        je1.setName("mohith");
        je1.setJobRole("Intern");
        juniorEmployeeList.add(je);
        juniorEmployeeList.add(je1);
        when(juniorEmployeeRepository.findAll()).thenReturn(juniorEmployeeList);
        assertEquals(2,juniorEmployeeService.getAllJunior().size());

    }
}