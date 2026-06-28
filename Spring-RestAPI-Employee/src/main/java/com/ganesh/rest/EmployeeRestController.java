package com.ganesh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.dto.EmployeeDto;
import com.ganesh.entity.Employee;
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
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id) {
		
		Employee employee = employeeService.findEmployeeById(id);
		
		if (employee==null) {
			
			return new ResponseEntity<Employee>(employee,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> findAllEmployee() {
		
		List<Employee> all = employeeService.findAllEmployee();
		
		return new ResponseEntity<List<Employee>>(all,HttpStatus.OK);
	}
	
	
	
}
