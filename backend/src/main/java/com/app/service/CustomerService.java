package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.customException.UserDeactivateException;
import com.app.dao.CustomerDao;
import com.app.dao.UserDao;
import com.app.model.LoginCredentials;
import com.app.pojos.Customer;
import com.app.pojos.User;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;


	@Autowired
	private PasswordEncoder passEncoder;

	@Autowired
	private UserDao uDao;

	public Customer findById(int id) {
		Optional<Customer> customer = customerDao.findById(id);
		if (customer.isPresent())
			return customer.get();
		else
			return null;
	}

	public Customer addCustomer(Customer newCustomer) {
		String rawPass = newCustomer.getPassword();
		String encPassword = passEncoder.encode(rawPass);
		newCustomer.setPassword(encPassword);
		return customerDao.save(newCustomer);
	}

	public Customer getByEmailId(String email) {

		return customerDao.findByEmail(email);
	}

	public int getByStatus(String email) {
		User user = uDao.findByEmail(email);
		int status = user.getActive();
		if (status == 1)
			return 1;
		else if (status == 0)
			return -1;
		else
			return 0;

	}

	public Customer findCustomerByEmailAndPassword(LoginCredentials cred) throws UserDeactivateException {
		int byStatus = this.getByStatus(cred.getEmail());
		if (byStatus == 1) {
			Customer dbCust = this.getByEmailId(cred.getEmail());
			String rawPass = cred.getPassword();
			if (dbCust != null && passEncoder.matches(rawPass, dbCust.getPassword()))
				return dbCust;
		} else if (byStatus == -1)
			throw new UserDeactivateException("User is Deactivated!!");
		
			return null;

	}

	public boolean resetPassword(Customer cust) {
		Customer custPass = customerDao.findByEmail(cust.getEmail());

		if (custPass.getAnswer().equalsIgnoreCase(cust.getAnswer())) {
			custPass.setPassword(cust.getPassword());
			Customer updateCust = customerDao.save(custPass);
			if (updateCust != null)
				return true;

		}

		return false;

	}

}
