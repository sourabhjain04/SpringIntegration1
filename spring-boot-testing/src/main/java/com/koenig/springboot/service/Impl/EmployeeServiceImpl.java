package com.koenig.springboot.service.Impl;

import com.koenig.springboot.exception.ResourceNotFoundException;
import com.koenig.springboot.model.Employee;
import com.koenig.springboot.repository.EmployeeRepository;
import com.koenig.springboot.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> savedEmployee = employeeRepository.findByEmail(employee.getEmail());
        if(savedEmployee.isPresent()){
            throw new ResourceNotFoundException("Employee already exist with given email:" + employee.getEmail());
        }
        return employeeRepository.save(employee);

	}

	public Optional<Employee> getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
        return employeeRepository.findAll();
	}

	
	public Employee updateEmployee(Employee updatedEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(updatedEmployee);
	}

	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
        employeeRepository.deleteById(id);
		
	}
   
}
 
