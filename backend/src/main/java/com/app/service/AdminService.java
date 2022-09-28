package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.AdminDao;
import com.app.dao.UserDao;
import com.app.model.LoginCredentials;
import com.app.pojos.Admin;
import com.app.pojos.User;

@Service
public class AdminService implements IAdminService {

	@Autowired
	AdminDao adminDao;
	@Autowired
	private UserDao uDao;

	@Autowired
	private PasswordEncoder passEncoder;

	public AdminService() {
		System.out.println("In Constructor of " + this.getClass().getName());
	}

	@Override
	public Admin findById(int id) {
		Optional<Admin> admin = adminDao.findById(id);
		if (admin.isPresent())
			return admin.get();
		else
			return null;
	}

	@Override
	public Admin getByEmailId(String emailId) {

		return adminDao.findByEmail(emailId);
	}

	public boolean getByStatus(String email) {
		User user = uDao.findByEmail(email);
		int status = user.getActive();
		if (status == 1)
			return true;
		else
			return false;

	}

	@Override
	public Admin addAdmin(Admin newAdmin) {
		String rawPass = newAdmin.getPassword();
		String encPassword = passEncoder.encode(rawPass);
		newAdmin.setPassword(encPassword);
		return adminDao.save(newAdmin);
	}

	public Admin findAdminByEmailAndPassword(LoginCredentials cred) {
		if (this.getByStatus(cred.getEmail())) {
			Admin dbCust = getByEmailId(cred.getEmail());
			String rawPass = cred.getPassword();
			if (dbCust != null && passEncoder.matches(rawPass, dbCust.getPassword()))
				return dbCust;
		}
		return null;
	}

	
	
	public boolean resetPassword(Admin emp) {
		//System.out.println(emp);
		Admin empPass = adminDao.findByEmail(emp.getEmail());
		//System.out.println(empPass);

		if (empPass != null && empPass.getAnswer().equalsIgnoreCase(emp.getAnswer())) {
			empPass.setPassword(emp.getPassword());
			Admin updateEmp = this.addAdmin(empPass);
			if (updateEmp != null)
				return true;
		}

		return false;

	}
}
