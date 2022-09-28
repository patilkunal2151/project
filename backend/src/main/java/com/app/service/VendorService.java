package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.customException.RecordNotFoundException;
import com.app.customException.UserDeactivateException;
import com.app.dao.UserDao;
import com.app.dao.VendorDao;
import com.app.model.LoginCredentials;
import com.app.pojos.User;
import com.app.pojos.Vendor;

@Service
public class VendorService implements IVendorService {

	@Autowired
	private VendorDao vendorDao;

	@Autowired
	private PasswordEncoder passEncoder;

	@Autowired
	private UserDao uDao;

	public VendorService() {
		System.out.println("In Constructor of " + this.getClass().getName());
	}

	@Override
	public Vendor findById(int id) {
		Optional<Vendor> vendor = vendorDao.findById(id);
		if (vendor.isPresent())
			return vendor.get();
		else

			return null;

	}

	@Override
	public Vendor addVendor(Vendor newVendor) {
		System.out.println(newVendor);
		String rawPass = newVendor.getPassword();
		String encPassword = passEncoder.encode(rawPass);
		newVendor.setPassword(encPassword);
		return vendorDao.save(newVendor);
	}

	@Override
	public void deleteVendor(int id) {

		// chk if product exists : yes : delete , otherwise throw exc.

		Optional<Vendor> optional = vendorDao.findById(id);
		if (optional.isPresent())
			vendorDao.deleteById(id);
		else {
			// if product is not found : throw custom exception
			System.out.println("Not Founded");

			throw new RecordNotFoundException("vendor not found");
		}
	}

	@Override
	public Vendor getByEmailId(String email) {

		return vendorDao.findByEmail(email);
	}

	public List<Vendor> findAll() {

		return vendorDao.findAll();

	}

	public List<Vendor> getAllVendByAddress(String address) {
		return vendorDao.findByAddress(address);
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

	public Vendor findVendorByEmailAndPassword(LoginCredentials cred) throws UserDeactivateException {
		int status = this.getByStatus(cred.getEmail());
		if (status == 1) {
			Vendor dbCust = getByEmailId(cred.getEmail());
			String rawPass = cred.getPassword();
			if (dbCust != null && passEncoder.matches(rawPass, dbCust.getPassword()))
				return dbCust;
		} else if (status == -1)
			throw new UserDeactivateException("Vendor is Deactivated !!");
		return null;
	}

	public boolean resetPassword(Vendor emp) {
		Vendor empPass = vendorDao.findByEmail(emp.getEmail());

		if (empPass.getAnswer().equalsIgnoreCase(emp.getAnswer())) {
			empPass.setPassword(emp.getPassword());
			Vendor updateEmp = vendorDao.save(empPass);
			if (updateEmp != null)
				return true;
		}

		return false;

	}
	
	

}
