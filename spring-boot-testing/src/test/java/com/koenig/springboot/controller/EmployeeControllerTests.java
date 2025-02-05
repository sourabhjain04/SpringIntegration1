package com.koenig.springboot.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.hamcrest.CoreMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.koenig.springboot.model.Employee;
import com.koenig.springboot.service.EmployeeService;
@WebMvcTest
public class EmployeeControllerTests {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{
    	
			//given - precondition or setup 
    		Employee employee = Employee.builder()
    				.firstName("Ramesh")
    				.lastName("fadatare")
    				.email("ramesh@gmail.com")
    				.build();
    		BDDMockito.given(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class)))
            .willAnswer((invocation)-> invocation.getArgument(0));
    	
			//when- action or the behavior that we are going to test
    		ResultActions response = mockMvc.perform(post("/api/employees")
    	            .contentType(MediaType.APPLICATION_JSON)
    	            .content(objectMapper.writeValueAsString(employee)));
    	
    	
			//then - verify the output using assert statement
    		  response.andDo(print()).andExpect(MockMvcResultMatchers.status().isCreated())
    		  	.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", 
    		  			CoreMatchers.is(employee.getFirstName())))
    		  	.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", 
    		  			CoreMatchers.is(employee.getLastName())))
    		  	.andExpect(MockMvcResultMatchers.jsonPath("$.email", 
    		  			CoreMatchers.is(employee.getEmail())));
    		  	
    }
}

