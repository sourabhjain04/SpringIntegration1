package com.koenig.springboot.service;

import java.util.List;
import java.util.Optional;

import com.koenig.springboot.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	Optional<Employee>getEmployeeById(long id);
	
	List<Employee> getAllEmployees();
    Employee updateEmployee(Employee updatedEmployee);
    void deleteEmployee(long id);

}
