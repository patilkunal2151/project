package com.vsms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsms.dtos.Credentials;
import com.vsms.pojos.Vendor;
import com.vsms.service.VendorServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/vendor")
public class VendorControllerImpl {

	@Autowired
	private VendorServiceImpl vservice;

// =============================================================================================================

	@GetMapping("/{id}")
	public ResponseEntity<?> getVendorById(@PathVariable("id") int id) {
		try {
			Vendor vend = vservice.findById(id);
			if (vend == null)
				return Response.status(HttpStatus.NOT_FOUND);
			return Response.success(vend);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//=============================================================================================================
	@GetMapping("/")
	public ResponseEntity<?> getAllVendors() {
		try {
			List<Vendor> vends = vservice.findAllVendor();
			if (vends == null)
				return Response.error("Vendors not Found");
			return Response.success(vends);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
//==========================================================================================================

	@PostMapping("/addVendor")
	public ResponseEntity<?> addVendor(@RequestBody Vendor vend) {
		try {
			Vendor vends = vservice.save(vend);
			return Response.success(vends);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//==========================================================================================================

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateVendor(@PathVariable("id") int id, @RequestBody Vendor vend) throws Exception {
		vend.setVid(id);
		try {
			Vendor vends = vservice.save(vend);
			if (vends != null)
				return Response.success(vends);
			else
				return Response.status(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//=============================================================================================================

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable("id") int id) {
		try {
			int i = vservice.deletedVendorById(id);
			if (i == 0)
				return Response.status(HttpStatus.NOT_FOUND);
			return Response.success("Vendor deleted ");
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//=============================================================================================================	

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@Valid @RequestBody Credentials cred) {
		Vendor vend = vservice.findVendorByEmailAndPassword(cred);
		if (vend == null)
			return Response.error("Customer Not Found");
		return Response.success(vend);
	}
//=============================================================================================================

}
