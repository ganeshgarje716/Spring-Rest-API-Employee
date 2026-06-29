package com.ganesh.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.dto.EmployeeDto;
import com.ganesh.entity.Employee;
import com.ganesh.exception.EmployeeNotFoundException;
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



	@Override
	public Employee findEmployeeById(Integer id) {

		Optional<Employee> byId = employeeRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Employee employee = byId.get();
			
			return employee;
		}
		
		throw new EmployeeNotFoundException("Employee Not Found For Id = "+id);
	}



	@Override
	public List<Employee> findAllEmployee() {

		List<Employee> all = employeeRepository.findAll();
		
		return all;
	}



	@Override
	public String updateEmployeeById(Integer id, Employee employee) {

		Optional<Employee> byId = employeeRepository.findById(id);
		
		if (byId.isPresent()) {
			
			Employee existing = byId.get();
			
			existing.setName(employee.getName());
			existing.setSalary(employee.getSalary());
			existing.setDepartment(employee.getDepartment());
			existing.setAddress(employee.getAddress());
			existing.setMobileNo(employee.getMobileNo());
			
			employeeRepository.save(existing);
			
			return "Employee Update Success";
		}
		
		throw new EmployeeNotFoundException("Employee Not Found For Id = "+id);
	}



	@Override
	public String deleteEmployeeById(Integer id) {

		if (employeeRepository.existsById(id)) {
			
			employeeRepository.deleteById(id);
			
			return "Delete Employee Success";
		}
		
		throw new EmployeeNotFoundException("Employee Not Found For Id = "+id);
	}

}
