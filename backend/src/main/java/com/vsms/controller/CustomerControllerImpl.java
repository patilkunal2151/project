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
import com.vsms.pojos.Customer;
import com.vsms.service.CustomerServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl {

	@Autowired
	private CustomerServiceImpl cService;

//===================================================GetCustomerById==================================================================

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") int id) {
		try {
			Customer cust = cService.findById(id);
			if (cust == null)
				return Response.error(HttpStatus.NOT_FOUND);
			return Response.success(cust);

		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
//==================================================GetAllCustomer================================================================

	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		try {
			List<Customer> result = cService.findAllCustomer();
			return Response.success(result);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//===============================================SignUpCustomer==================================================================

	@PostMapping("/signup")
	public ResponseEntity<?> save(@Valid @RequestBody Customer cust) {
		try {
			Customer result = cService.saveCustomer(cust);
			return Response.success(result);

		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//================================================DeleteCustomerById==============================================================

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		try {
			int Count = cService.deletUserById(id);
			return Response.success(Count);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
// =========================================UpdateCustomerById=================================================================

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable(value = "id") int Customerid,
			@Valid @RequestBody Customer updateDetails) throws Exception {
		updateDetails.setId(Customerid);
		try {
			@Valid
			Customer sav = cService.updateCustomer(updateDetails);
			if (sav != null) {
				return Response.success(sav);
			} else {
				return Response.status(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
//===========================================CustomerSignIn==================================================================================

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@Valid @RequestBody Credentials cred) {
		Customer cust = cService.findCustomerByEmailAndPassword(cred);
		if (cust == null)
			return Response.error("Customer Not Found");
		return Response.success(cust);
	}
//=================================================================================================================

}
