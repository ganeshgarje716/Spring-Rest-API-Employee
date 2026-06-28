package com.ganesh.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.dto.EmployeeDto;
import com.ganesh.entity.Employee;
import com.ganesh.repository.EmployeeRepository;
import com.ganesh.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	
	
	@Autowired
	EmployeeRepository employeeRepository;

	
	
	@Override
	public String saveEmployee(EmployeeDto employeeDto) {

		Employee entity=new Employee();
		
		entity.setName(employeeDto.getName());
		entity.setSalary(employeeDto.getSalary());
		entity.setDepartment(employeeDto.getDepartment());
		entity.setAddress(employeeDto.getAddress());
		entity.setMobileNo(employeeDto.getMobileNo());
		
		employeeRepository.save(entity);
		
		return "Employee Saved Success";
		
	}

}
