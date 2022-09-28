package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.customException.UserDeactivateException;
import com.app.dao.EmployeeDao;
import com.app.dao.UserDao;
import com.app.model.LoginCredentials;
import com.app.pojos.Employee;
import com.app.pojos.User;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private PasswordEncoder passEncoder;
	@Autowired
	private UserDao uDao;

	public EmployeeService() {
		System.out.println("In Constructor of " + this.getClass().getName());
	}

	public Employee findById(int id) {
		Optional<Employee> employee = employeeDao.findById(id);
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}

	public List<Employee> getAllByVendorId(int vendorId) {
		List<Employee> list = null;
		list = employeeDao.findAllByVendorId(vendorId);

		if (list != null)
			return list;
		else
			return null;

	}

	public Employee addEmployee(Employee newEmployee) {
		String rawPass = newEmployee.getPassword();
		String encPassword = passEncoder.encode(rawPass);
		newEmployee.setPassword(encPassword);
		return employeeDao.save(newEmployee);
	}

	public Employee getByEmailId(String emailId) {

		return employeeDao.findByEmail(emailId);

	}

	public int getByStatus(String email) {
		User user = uDao.findByEmail(email);
		int status = user.getActive();
		if (status == 1)
			return 1;
		else if (status == 0)
			return -1;
		return 0;
	}

	public Employee findEmployeeByEmailAndPassword(LoginCredentials cred) throws UserDeactivateException {
		int byStatus = this.getByStatus(cred.getEmail());
		if (byStatus == 1) {
			Employee dbCust = getByEmailId(cred.getEmail());
			String rawPass = cred.getPassword();
			if (dbCust != null && passEncoder.matches(rawPass, dbCust.getPassword()))
				return dbCust;
		} else if (byStatus == -1)
			throw new UserDeactivateException("Employee is Deactivated !!");
		
		return null;
	}
	
	

	public boolean resetPassword(Employee emp) {
		Employee empPass = employeeDao.findByEmail(emp.getEmail());

		if (empPass.getAnswer().equalsIgnoreCase(emp.getAnswer())) {
			empPass.setPassword(emp.getPassword());
			Employee updateEmp = employeeDao.save(empPass);
			if (updateEmp != null)
				return true;
		}

		return false;

	}

}
