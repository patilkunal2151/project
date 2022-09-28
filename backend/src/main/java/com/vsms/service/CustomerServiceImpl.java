package com.vsms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vsms.dao.CustomerDao;
import com.vsms.dtos.Credentials;
import com.vsms.pojos.Customer;

@Transactional
@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private PasswordEncoder passEncoder;

//=============================================================================
	public Customer findById(int id) {

		System.out.println("In Customer Service");
		if (dao.existsById(id)) {
			Customer customer = dao.findById(id);
			return customer;
		} else
			return null;
	}

//===============================================================================
	Customer findCustomerByEmail(String email) {
		Customer cust = dao.findByEmail(email);
		return cust;
	}

//==========================================================================================
	public List<Customer> findAllCustomer() {
		return dao.findAll();
	}

//==========================================================================================
	public Customer updateCustomer(Customer cust) {
		return dao.save(cust);
	}

//============================================================================================
	public int deletUserById(int id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return 1;
		}
		return 0;
	}
//=============================================================================================================

	public Customer saveCustomer(Customer cust) {
		return dao.save(cust);
	}

//	public Customer saveCustomer(Customer cust) {
//		String rawPass = cust.getPass();
//		String encPassword = passEncoder.encode(rawPass);
//		cust.setPass(encPassword);
//		return dao.save(cust);
//	}

//=============================================================================================================	

	public Customer findCustomerByEmailAndPassword(Credentials cred) {
		Customer dbCust = this.findCustomerByEmail(cred.getEmail());
		if (dbCust != null && dbCust.getPass().equals(cred.getPass()))
			return dbCust;
		return null;
	}

//	public Customer findCustomerByEmailAndPassword(Credentials cred) {
//		Customer dbCust = this.findCustomerByEmail(cred.getEmail());
//	String rawPass = cred.getPassword()));
//		if (dbCust != null && passEncoder.matches(rawPass,dbCust.getPass()))
//			return dbCust;
//		return null;
//	}

//=============================================================================================================

}
