package com.projectworld.ProjectWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectworld.ProjectWorld.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
