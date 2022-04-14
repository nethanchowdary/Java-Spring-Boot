package com.example.taskmongo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import com.example.taskmongo.controller.EmployeeRestController;
import com.example.taskmongo.dto.EmployeeDetails;
import com.example.taskmongo.entity.Employee;
import com.example.taskmongo.service.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
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

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeRestController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    @Test
    public void testCreateEmployee() throws Exception{

        Employee mockEmployee= new Employee();
        //mockEmployee.setUserid(1L);
        mockEmployee.setUserName("nethan");
        mockEmployee.setFullName("nethanp");
        mockEmployee.setEmailId("nethan@gmail.com");
        mockEmployee.setAddress("bnglr");
        mockEmployee.setMobileNumber(8142337274L);
        mockEmployee.setCurrentOrganization("capgemini");

        String inputInJson = this.mapToJson(mockEmployee);

        String URI = "/addEmployee";

        Mockito.when(service.addEmployee(Mockito.any(EmployeeDetails.class))).thenReturn(mockEmployee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());


        }
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
