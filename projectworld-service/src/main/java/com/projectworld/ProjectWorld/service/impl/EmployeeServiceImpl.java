package com.projectworld.ProjectWorld.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectworld.ProjectWorld.entity.Employee;
import com.projectworld.ProjectWorld.exceptions.ResourceNotFoundException;
import com.projectworld.ProjectWorld.repo.EmployeeRepo;
import com.projectworld.ProjectWorld.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return empRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public long deleteEmployeeById(Long id) {
		long isSuccess = 0;
		try {
			empRepo.deleteById(id);
			isSuccess = 1;
		} catch (Exception e) {
			throw new RuntimeException("Error while deleting employee");
		}
		return isSuccess;
	}
}
