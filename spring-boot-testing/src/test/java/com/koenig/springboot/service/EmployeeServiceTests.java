package com.koenig.springboot.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import com.koenig.springboot.model.Employee;
import com.koenig.springboot.repository.EmployeeRepository;
import com.koenig.springboot.service.Impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

		@Mock
	  private EmployeeRepository employeeRepository;
		
		

		@InjectMocks
	    private EmployeeServiceImpl employeeService;
	 

	    // JUnit test for saveEmployee method
	    @DisplayName("JUnit test for saveEmployee method")
	    @Test
	    public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeObject(){
	    	
	        // given - precondition or setup
	    	Employee employee = Employee.builder()
	                 .id(1L)
	                 .firstName("Ramesh")
	                 .lastName("Fadatare")
	                 .email("ramesh@gmail.com")
	                 .build();
	    	// here we are mocking the method of employeeRepository class i.e findByEmail and sav\e
	     given(employeeRepository.findByEmail(employee.getEmail()))
	                .willReturn(Optional.empty());

	      given(employeeRepository.save(employee)).willReturn(employee);

	        System.out.println(employeeRepository);
	        System.out.println(employeeService);

	        // when -  action or the behaviour that we are going test
	        Employee savedEmployee = employeeService.saveEmployee(employee);

	                System.out.println(savedEmployee);
	        // then - verify the output
	        Assertions.assertThat(savedEmployee).isNotNull();
	    }

	
	
}
