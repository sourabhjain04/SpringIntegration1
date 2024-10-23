package com.koenig.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.koenig.springboot.model.Employee;


@DataJpaTest
public class EmployeeRepositoryTests {
	// inject the employee repository
	@Autowired
	private EmployeeRepository employeeRepository;

	
	// junit test to save the employee operations
	@DisplayName("Junit test for employee operations")
	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
		// given - precondition or setup
		Employee employee = Employee.builder()
				.firstName("Vedika")
				.lastName("jain")
				.email("vj@gamil.com")
				.build();
		
		
		// when - action or the behaviour that we are going to test
		
		Employee savedEmployee = employeeRepository.save(employee);
		// then - verify the output
		
		Assertions.assertThat(savedEmployee).isNotNull();
		
		Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
		
		
	}
	
	
	@DisplayName("Junit test for get all employees operation")
	@Test
	public void givenEmployeesList_whenFindAll_thenEmployeesList() {
		//given - precondition or setup 
		Employee employee= Employee.builder()
				.firstName("Ramesh")
               			 .lastName("Ramesh")
               			 .email("ramesh@gmail,com")
               			 .build();
		
		Employee employee1= Employee.builder()
				 .firstName("Jhon")
             				  .lastName("Cena")
               			 .email("Cena@gmail,com")
               			 .build();
				
		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		//when- action or the behavior that we are going to test
		
		List<Employee> emplyeeList = employeeRepository.findAll();
		
		//then - verify the output
		assertThat(emplyeeList).isNotNull();
		assertThat(emplyeeList.size()).isEqualTo(2);
		
	}
	
	// JUnit test for get employee by id operation
    @DisplayName("JUnit test for get employee by id operation")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Ramesh")
                .email("ramesh@gmail,com")
                .build();
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee employeeDB = employeeRepository.findById(employee.getId()).get();

        // then - verify the output
        assertThat(employeeDB).isNotNull();
    }
    
    // JUnit test for get employee by email operation
    @DisplayName("JUnit test for get employee by email operation")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail,com")
                .build();
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();
        // then - verify the output
        assertThat(employeeDB).isNotNull();
    }


 // JUnit test for update employee operation
    @DisplayName("JUnit test for update employee operation")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail,com")
                .build();
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("ram@gmail.com");
        savedEmployee.setFirstName("Ram");
        Employee updatedEmployee =  employeeRepository.save(savedEmployee);

        // then - verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("ram@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Ram");
    }
 // JUnit test for custom query using JPQL with index parameters
    @DisplayName("JUnit test for custom query using JPQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject(){
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail,com")
                .build();
        employeeRepository.save(employee);
        String firstName = "Ramesh";
        String lastName = "Fadatare";

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

	
    

	
}
