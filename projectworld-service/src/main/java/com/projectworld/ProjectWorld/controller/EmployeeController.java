package com.projectworld.ProjectWorld.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectworld.ProjectWorld.entity.Employee;
import com.projectworld.ProjectWorld.service.EmployeeService;

@RestController
@RequestMapping("/employees/")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	// get all employees
	@GetMapping("/")
	public List<Employee> showAllEmployees() {
		return empService.getAllEmployees();
	}

	// create a new employee and save in DB
	@PostMapping("/save-employee")
	public Employee createEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}

	// get an existing employee through ID
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long id) {
		Employee empObj = empService.getEmployeeById(id);
		return ResponseEntity.ok(empObj);
	}

	// update the existing employee data
	@PostMapping("/edit-employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee newEmp) {
		boolean toUpdate = false;
		Employee oldEmpObj = empService.getEmployeeById(id);
		if (!oldEmpObj.getFirstName().equals(newEmp.getFirstName())) {
			oldEmpObj.setFirstName(newEmp.getFirstName());
			toUpdate = true;
		}
		if (!oldEmpObj.getLastName().equals(newEmp.getLastName())) {
			oldEmpObj.setLastName(newEmp.getLastName());
			toUpdate = true;
		}
		if (!oldEmpObj.getEmailId().equals(newEmp.getEmailId())) {
			oldEmpObj.setEmailId(newEmp.getEmailId());
			toUpdate = true;
		}
		if (toUpdate) {
			newEmp = empService.updateEmployee(oldEmpObj);
		}
		return ResponseEntity.ok(newEmp);
	}

	// delete employee by id
	@DeleteMapping("/delete-employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeById(@PathVariable Long id) {
		Map<String, Boolean> mapToReturn = new HashMap<>();
		long isSuccess = empService.deleteEmployeeById(id);
		if (isSuccess == 1) {
			mapToReturn.put("deleted", true);
		} else {
			mapToReturn.put("error", false);
		}
		return ResponseEntity.ok(mapToReturn);
	}
}
