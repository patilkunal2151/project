package com.vsms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsms.dao.EmployeeDao;
import com.vsms.dtos.Credentials;
import com.vsms.pojos.Employee;

@Transactional
@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDao empDao;

//============================================================================================================
	
	public Employee findById(int id) {
		if (empDao.existsById(id)) {
			Employee emp = empDao.findById(id);
			return emp;
		}
		return null;
	}
//=============================================================================================================

	public List<Employee> findAllEmployee() {
		return empDao.findAll();
	}
//=============================================================================================================

	public Employee findByEmail(String email) {
		Employee emp = empDao.findByEmail(email);
		return emp;
	}
//=============================================================================================================	

	public Employee save(Employee emp) {
		return empDao.save(emp);
	}

//===========================================================================================================

	public Employee findEmployeeByEmailAndPassword(Credentials cred) {
		Employee dbEmp = empDao.findByEmail(cred.getEmail());
		if (dbEmp != null && dbEmp.getPass().equals(cred.getPass())) {
			return dbEmp;
		}
		return null;
	}
//================================================================================================================	

	public int deleteEmployeeById(int id) {
		if (empDao.existsById(id)) {
			empDao.deleteById(id);
			return 1;
		}
		return 0;
	}
//================================================================================================================

	
}
