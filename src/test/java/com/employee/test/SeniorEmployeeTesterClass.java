package com.employee.test;

import com.employee.entity.SeniorEmployee;
import com.employee.repository.SeniorEmployeeRepository;
import com.employee.service.SeniorEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class SeniorEmployeeTesterClass {

    @Autowired
    private SeniorEmployeeService seniorEmployeeService;

    @MockBean
    private SeniorEmployeeRepository seniorEmployeeRepository;

    @Test
    public void getAllSeniorEmployeeTest() {
        when(seniorEmployeeRepository.findAll()).thenReturn((Stream.of(new SeniorEmployee(1, "vasanth", "Javadeveloper", 40000)).collect(Collectors.toList())));
        assertEquals(1, seniorEmployeeService.getAllSeniorEmployees().size());
    }

    @Test
    public void getSeniorEmployeeByIdTest()
    {
        SeniorEmployee seniorEmployee = new SeniorEmployee(1, "vasanth", "Javadeveloper", 40000);
        when(seniorEmployeeRepository.findById(1)).thenReturn(Optional.of(seniorEmployee));
        assertEquals(seniorEmployee,seniorEmployeeService.getSeniorEmployeeById(1));
    }

    @Test
    public void addSeniorEmployeeTest() {
        SeniorEmployee seniorEmployee = new SeniorEmployee(1, "vasanth", "Javadeveloper", 40000);
        when(seniorEmployeeRepository.save(seniorEmployee)).thenReturn(seniorEmployee);
        assertEquals(seniorEmployee, seniorEmployeeService.addSeniorEmployee(seniorEmployee));

    }

    @Test
    public void deleteSeniorEmployeeByIdTest() {
        SeniorEmployee seniorEmployee = new SeniorEmployee(1, "vasanth", "Javadeveloper", 40000);
        when(seniorEmployeeRepository.findById(1)).thenReturn(Optional.of(seniorEmployee));
        seniorEmployeeService.deleteSeniorEmployeeById(1);
        verify(seniorEmployeeRepository, times(1)).delete(seniorEmployee);
    }

    @Test
    public void getSeniorEmployeeByJobRoleTest() {

        when(seniorEmployeeRepository.getSeniorEmployeeByJobRole("Javadeveloper")).thenReturn(Stream.of(new SeniorEmployee(1, "vasanth", "Javadeveloper", 40000)).collect(Collectors.toList()));

        assertEquals(1, seniorEmployeeService.getSeniorEmployeeByJobRole("Javadeveloper").size());
    }
}
