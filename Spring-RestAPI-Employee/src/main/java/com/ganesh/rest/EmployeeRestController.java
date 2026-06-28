package com.ganesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.dto.EmployeeDto;
import com.ganesh.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeRestController {

	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		
		String save = employeeService.saveEmployee(employeeDto);
		
		return new ResponseEntity<String>(save, HttpStatus.CREATED);
	}
}
