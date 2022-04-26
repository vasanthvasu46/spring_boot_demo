package com.employee.test;


import com.employee.controller.SeniorEmployeeController;
import com.employee.entity.JuniorEmployee;
import com.employee.entity.SeniorEmployee;
import com.employee.service.JuniorEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
public class JuniorEmployeeControllerTester {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JuniorEmployeeService juniorEmployeeService;

    List<JuniorEmployee> juniorEmployeeList = new ArrayList<>();

    @Test
    public void getAllJuniorEmployeesTest() throws Exception {

        JuniorEmployee je = new JuniorEmployee();
        je.setId(1);
        je.setName("mohith");
        je.setLocation("Coimbatore");
        je.setSeniorEmployee(new SeniorEmployee(1, "", 0, ""));

        juniorEmployeeList.add(je);

        Mockito.when(juniorEmployeeService.getJuniorEmployeesBySeniorID(1)).thenReturn(juniorEmployeeList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees/senior/{seniorId}/junior")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "[{\"id\":1,\"name\":\"mohith\",\"location\":\"Coimbatore\",seniorEmployeeList[{\"id\":1,\"name\":null,\"salary\":0\"location\":null}]}]";

        assertEquals(expected, result.getResponse().getContentAsString());


    }
}
