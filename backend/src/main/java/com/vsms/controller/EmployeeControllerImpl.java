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
import com.vsms.pojos.Employee;
import com.vsms.service.EmployeeServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeControllerImpl {

	@Autowired
	private EmployeeServiceImpl empServices;

// =============================================================================================================

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) {
		try {
			Employee emp = empServices.findById(id);
			if (emp == null)
				return Response.status(HttpStatus.NOT_FOUND);
			return Response.success(emp);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//=============================================================================================================
	
	@GetMapping("/")
	public ResponseEntity<?> getAllEmployee() {
		try {
			List<Employee> emp = empServices.findAllEmployee();
			if (emp == null)
				return Response.error("Vendors not Found");
			return Response.success(emp);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
//==========================================================================================================

	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		try {
			Employee vends = empServices.save(emp);
			return Response.success(vends);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//==========================================================================================================

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") int id, @RequestBody Employee emp) throws Exception {
		emp.setId(id);
		try {
			Employee vends = empServices.save(emp);
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
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
		try {
			int i = empServices.deleteEmployeeById(id);
			if (i == 0)
				return Response.status(HttpStatus.NOT_FOUND);
			return Response.success("Employee deleted ");
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}

//=============================================================================================================	

	@PostMapping("/signin")
	public ResponseEntity<?>EmployeeSignIn(@Valid @RequestBody Credentials cred) {
		Employee vend = empServices.findEmployeeByEmailAndPassword(cred);
		if (vend == null)
			return Response.error("Customer Not Found");
		return Response.success(vend);
	}
	
//=============================================================================================================

}
