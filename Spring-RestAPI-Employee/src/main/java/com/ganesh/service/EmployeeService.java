package com.ganesh.service;

import java.util.List;

import com.ganesh.dto.EmployeeDto;
import com.ganesh.entity.Employee;

public interface EmployeeService {
	
	
	String saveEmployee(EmployeeDto employeeDto);
	
	Employee findEmployeeById(Integer id);
	
	List<Employee> findAllEmployee();

	

}
