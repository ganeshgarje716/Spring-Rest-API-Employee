package com.ganesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeRestController {

	
	@Autowired
	EmployeeService employeeService;
}
