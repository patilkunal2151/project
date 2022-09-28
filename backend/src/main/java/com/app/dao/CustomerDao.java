package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByEmailAndPassword(String email, String password);

	Customer findByEmail(String email);
	
	List<Customer>findAll();

	List<Customer> findAllByEmployeeId(int employee_id);

	Optional<Customer> findById(int id);

//    @Query("select id,address,birth_date,contact,email,employee_id,name,password from customer where address=(select address from vendor where id = ?1)")
//	Optional<Customer> findSpecificCustomerByVendorId(int vendorId);

	List<Customer> findAllByAddress(String address);

	List<Customer> findByAddress(String address);

//    @Query("SELECT id,address,birth_date,contact,email,employee_id,name,password from customer where address=(select address from vendor where id = ?);", nativeQuery = true)
//	List<Customer> findSpecificCustomerByVendorId(int vendorId);

}
