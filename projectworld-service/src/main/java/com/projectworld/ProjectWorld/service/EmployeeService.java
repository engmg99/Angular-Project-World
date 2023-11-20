package com.projectworld.ProjectWorld.service;

import java.util.List;

import com.projectworld.ProjectWorld.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee saveEmployee(Employee emp);

	public Employee getEmployeeById(Long id);

	public Employee updateEmployee(Employee emp);

	public long deleteEmployeeById(Long id);
}
