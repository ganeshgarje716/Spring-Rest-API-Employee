package com.ganesh.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.ganesh.repository.EmployeeRepository;
import com.ganesh.service.EmployeeService;

public class EmployeeServiceImp implements EmployeeService{
	
	
	@Autowired
	EmployeeRepository employeeRepository;

}
