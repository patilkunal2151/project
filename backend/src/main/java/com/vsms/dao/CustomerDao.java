package com.vsms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsms.pojos.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {


	Customer findByEmail(String email);

	List<Customer> findAllById(int id);

	Customer findById(int id);
	
	
}
