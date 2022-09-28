package com.vsms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vsms.dao.VendorDao;
import com.vsms.dtos.Credentials;
import com.vsms.pojos.Vendor;

@Transactional
@Service
public class VendorServiceImpl {

	@Autowired
	private VendorDao vdao;

	@Autowired
	private PasswordEncoder passEncoder;
//==============================================================================================================
	public List<Vendor> findAllVendor() {
		List<Vendor> list = vdao.findAll();
		return list;
	}
//==============================================================================================================
	public Vendor findById(int id) {
		if (vdao.existsById(id)) {
			Vendor vend = vdao.findByVid(id);
			return vend;
		} else
			return null;
	}
//==============================================================================================================
	public Vendor findByEmail(String email) {
		Vendor vend = vdao.findByEmail(email);
		return vend;
	}

//==============================================================================================================
	public Vendor save(Vendor vend) {
		return vdao.save(vend);
	}

//	public Vendor saveCustomer(Vendor cust) {
//	String rawPass = cust.getPass();
//	String encPassword = passEncoder.encode(rawPass);
//	cust.setPass(encPassword);
//	return vdao.save(cust);
//}
//===============================================================================================================
	public int deletedVendorById(int id) {
		if (vdao.existsById(id)) {
			vdao.deleteById(id);
			return 1;
		}
		return 0;
	}

//===============================================================================================================
	public Vendor findVendorByEmailAndPassword(Credentials cred) {
		Vendor vend = this.findByEmail(cred.getEmail());
		if (vend != null && vend.getPass().equals(cred.getPass())) {
			return vend;
		} else
			return null;
	}

//================================================================================================================


}
