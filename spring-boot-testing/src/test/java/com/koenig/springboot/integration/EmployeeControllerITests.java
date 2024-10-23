package com.koenig.springboot.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koenig.springboot.model.Employee;
import com.koenig.springboot.repository.EmployeeRepository;
import com.koenig.springboot.service.EmployeeService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmployeeControllerITests {
	@Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @BeforeEach
    void setup() {
    	employeeRepository.deleteAll();
    }
	
    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{
    	
			//given - precondition or setup 
    		Employee employee = Employee.builder()
    				.firstName("Ramesh")
    				.lastName("fadatare")
    				.email("ramesh@gmail.com")
    				.build();
    		
    	
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
