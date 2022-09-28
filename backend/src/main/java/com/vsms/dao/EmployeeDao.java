package com.vsms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsms.pojos.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Employee findById(int id);
	
	List<Employee> findAllById(int id);
	
	Employee findByEmail(String email);
	
	
	
	
}
