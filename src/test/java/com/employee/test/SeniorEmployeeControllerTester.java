package com.employee.test;

import com.employee.controller.SeniorEmployeeController;
import com.employee.entity.JuniorEmployee;
import com.employee.entity.SeniorEmployee;
import com.employee.service.SeniorEmployeeService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@WebMvcTest(value = SeniorEmployeeController.class)
public class SeniorEmployeeControllerTester {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SeniorEmployeeService seniorEmployeeService;

    List<SeniorEmployee> seniorEmployeeList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAllSeniorEmployeesTest() throws Exception {
        SeniorEmployee seniorEmployee = new SeniorEmployee(1, "vasanth", 40000, "Coimbatore");
        JuniorEmployee je = new JuniorEmployee();
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeList.add(je);
        seniorEmployee.setJuniorEmployeeList(juniorEmployeeList);


        seniorEmployeeList.add(seniorEmployee);

        Mockito.when(seniorEmployeeService.getAllSeniorEmployees()).thenReturn(seniorEmployeeList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/senior").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        String expected = "[{\"id\":1,\"name\":\"vasanth\",\"salary\":40000,\"location\":\"Coimbatore\",\"juniorEmployeeList\":[{\"id\":0,\"name\":null,\"location\":null}]}]";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void getSeniorEmployeeByIdTest() throws Exception {
        SeniorEmployee seniorEmployee = new SeniorEmployee(1, "vasanth", 40000, "Coimbatore");
        JuniorEmployee je = new JuniorEmployee();
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeList.add(je);
        seniorEmployee.setJuniorEmployeeList(juniorEmployeeList);

        Mockito.when(seniorEmployeeService.getSeniorEmployeeById(1)).thenReturn(seniorEmployee);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/senior/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());

        System.out.println(result);

        String expected = "{\"id\":1,\"name\":\"vasanth\",\"salary\":40000,\"location\":\"Coimbatore\",\"juniorEmployeeList\":[{\"id\":0,\"name\":null,\"location\":null}]}";

        assertEquals(expected, result.getResponse().getContentAsString());

    }

    @Test
    public void addSeniorEmployeeTest() throws Exception {
        SeniorEmployee seniorEmployee = new SeniorEmployee(1, "vasanth", 40000, "Coimbatore");
        JuniorEmployee je = new JuniorEmployee();
        List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();
        juniorEmployeeList.add(je);
        seniorEmployee.setJuniorEmployeeList(juniorEmployeeList);

        Mockito.when(seniorEmployeeService.addSeniorEmployee(seniorEmployee)).thenReturn(seniorEmployee);

        String seniorJson = "{\"id\":1,\"name\":\"vasanth\",\"salary\":40000,\"location\":\"Coimbatore\",\"juniorEmployeeList\":[{\"id\":0,\"name\":null,\"location\":null}]}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/employees/senior").content(seniorJson).contentType(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(result.getResponse().getContentType());

        SeniorEmployee seniorEmployee1 = objectMapper.readValue(result.getResponse().getContentAsString(), SeniorEmployee.class);
        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());

        //s  System.out.println(result);
        // System.out.println("Senior Employee 1:"+seniorEmployee1);
        // String content= response.getContentAsString();
        //assertEquals("ADDED",content);
    }


}
