package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.app.dao.CustomerDao;
import com.app.dao.EmployeeDao;
import com.app.dao.FeedbackDao;
import com.app.dao.QuestionDao;
import com.app.dao.ServiceRequestDao;
import com.app.dao.VendorDao;
import com.app.model.LoginCredentials;
import com.app.pojos.Customer;
import com.app.pojos.Feedback;
import com.app.pojos.Question;
import com.app.pojos.ServiceRequest;
import com.app.pojos.Vehicle;
import com.app.service.CustomerService;
import com.app.service.ServiceRequestService;
import com.app.service.VehicleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // @Controller + @ResponseBody
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private VendorDao vendorDao;

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ServiceRequestDao serviceRequestDao;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private FeedbackDao feedbackDao;

	@Autowired
	private ServiceRequestService serviceRequestService;

	@Autowired
	private VehicleService vser;

	public CustomerController() {
		System.out.println("in ctor of " + getClass().getName());
	}

// ---------------------------------------------------------------------------
// Get Customer by id
// ---------------------------------------------------------------------------
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable int id) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("in fetch all Customer");

		try {
			Customer customer = customerService.findById(id);
			map.put("status", "success");
			map.put("data", customer);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			map.put("error", "Customers Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

// ---------------------------------------------------------------------------
// ________________________________Sign in Customer ________________________________
// ---------------------------------------------------------------------------
	@PostMapping("/signin")
	public ResponseEntity<?> signInCustomer(@RequestBody LoginCredentials cust) {
		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("in Customer signIn");
		try {
			Customer signin = customerService.findCustomerByEmailAndPassword(cust);
			System.out.println(signin);
			if (signin != null) {
				map.put("status", "success");
				map.put("data", signin);
				resp = new ResponseEntity<>(map, HttpStatus.OK);
			} else {
				map.put("status", "Error");
				map.put("data", "Wrong Credentials !!");
				resp = new ResponseEntity<>(map, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			resp = new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
		}
		return resp;
	}
// ---------------------------------------------------------------------------
// ________________________________Edit Customer________________________________
// ---------------------------------------------------------------------------

	@PutMapping("/editCustomer/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable(value = "id") int customer_id,
			@Valid @RequestBody Customer customerDetails) throws Exception {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		customerDetails.setId(customer_id);

		if (customerService.addCustomer(customerDetails) != null) {
			map.put("status", "success");
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", "error");
			map.put("error", "Student Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return resp;
	}

// ---------------------------------------------------------------------------
// ________________________________Forgot password Customer
// ---------------------------------------------------------------------------

	@PutMapping("/forgotPassword")
	public ResponseEntity<?> forgotPassword(@RequestBody Customer cust) {
		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("in Customer reset password");
		try {
			boolean signin = customerService.resetPassword(cust);
			if (signin == true) {
				map.put("status", "success");
				map.put("data", "Password changed");
				resp = new ResponseEntity<>(map, HttpStatus.OK);
			} else {
				map.put("status", "Error");
				map.put("data", "Wrong Answer !!");
				resp = new ResponseEntity<>(map, HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			resp = new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
		}
		return resp;
	}

// ---------------------------------------------------------------------------
// ________________________________Add Vehicle ________________________________
// ---------------------------------------------------------------------------
		@PostMapping("/addVehicle/{id}")
		public ResponseEntity<?> addVehicle(@PathVariable("id")int CustId, @RequestBody Vehicle cust) {
			ResponseEntity<?> resp = null;
			Map<String, Object> map = new HashMap<String, Object>();

			System.out.println("in Add Vehicle");
			cust.setCustomerId(CustId);
			try {
				Vehicle addvehicle =vser.addVehicle(cust);
				if (addvehicle != null) {
					map.put("status", "success");
					map.put("data", addvehicle);
					resp = new ResponseEntity<>(map, HttpStatus.OK);
				} else {
					map.put("status", "Error");
					map.put("data", "Null data");
					resp = new ResponseEntity<>(map, HttpStatus.NOT_ACCEPTABLE);
				}
			} catch (Exception e) {
				System.err.println("Exception : " + e.getMessage());
				map.put("status", "error");
				resp = new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
			}
			return resp;
		}	
	
// ---------------------------------------------------------------------------
// Get Vehicle by Customer id
// ---------------------------------------------------------------------------
	
		
		@GetMapping("/vehicleByCustomer/{id}")
	public ResponseEntity<?> getVehicleByCustomerId(@PathVariable int id) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("in fetch vehicle by Customer id");

		try {
			Vehicle vehicle = vser.findByCustomerId(id);
			map.put("status", "success");
			map.put("data", vehicle);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			map.put("error", "Customers Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

// ---------------------------------------------------------------------------
// _______________________Get Vehicle by VehicleId id____________________
// ---------------------------------------------------------------------------
	
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<?> getVehicleByVehicleId(@PathVariable int id) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("in fetch vehicle by Customer id");

		try {
			Optional<Vehicle> vehicle = vser.findByVehicleId(id);
			map.put("status", "success");
			map.put("data", vehicle);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			map.put("error", "Vehicle Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	
// ---------------------------------------------------------------------------
// __________________________Get all Vehicle______________________________
// ---------------------------------------------------------------------------
	@GetMapping("/allVehicle")
	public ResponseEntity<?> getAllVehicle() {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("in fetch All vehicle");

		try {
			List<Vehicle> vehicle = vser.findAllVehicle();
			map.put("status", "success");
			map.put("data", vehicle);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			map.put("error", "Customers Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

// ---------------------------------------------------------------------------
// ________________________________Remove Vehicle ________________________________
// ---------------------------------------------------------------------------
			@DeleteMapping("/deleteVehicle/{id}")
			public ResponseEntity<?> removeVehicle(@PathVariable("id") int id) {
				ResponseEntity<?> resp = null;
				Map<String, Object> map = new HashMap<String, Object>();

				System.out.println("in Customer signIn");
				try {
					int addvehicle =vser.removeVehicleByVid(id);
					if (addvehicle == 1) {
						map.put("status", "success");
						map.put("data", "Vehicle deleted Successfully !!");
						resp = new ResponseEntity<>(map, HttpStatus.OK);
					} else {
						map.put("status", "Error");
						map.put("data", "Vehicle Not Found");
						resp = new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
					}
				} catch (Exception e) {
					System.err.println("Exception : " + e.getMessage());
					map.put("status", "error");
					resp = new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
				}
				return resp;
			}	
	
// ------------------------------------------------------------------------
// ____________________Add Service Request
// ------------------------------------------------------------------
	@PostMapping("/addService/{vendorID}/{customer_id}")
	public ResponseEntity<?> createService(@Valid @RequestBody ServiceRequest serviceRequest,
			@PathVariable("customer_id") int customer_id , @PathVariable("vendorID") int VendorId) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();
		serviceRequest.setVendorId(VendorId);
		serviceRequest.setCustomerId(customer_id);

		if (serviceRequestService.addServiceRequest(serviceRequest) != null) {
			map.put("status", "success");
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", "error");
			map.put("error", "Can't Add service or RegNo found Duplicated");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

// ---------------------------------------------------------------------------
// __________________________________Add Question
// ---------------------------------------------------------------------------

	@PostMapping("/addQuestion")
	public ResponseEntity<?> createQuestion(@Valid @RequestBody Question question) {
		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("New question : " + question);
		if (questionDao.save(question) != null) {
			map.put("status", "success");
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", "error");
			map.put("error", "Can't Add Question");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

// ---------------------------------------------------------------------------
// _________________________________Add Feedback
// ---------------------------------------------------------------------------
	@PostMapping("/addFeedback")
	public ResponseEntity<?> createFeedback(@Valid @RequestBody Feedback feedback) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		if (feedbackDao.save(feedback) != null) {
			map.put("status", "success");
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", "error");
			map.put("error", "Can't Add feedback");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

// ---------------------------------------------------------------------------
// __________________________Get Feedback by customer Id
// ---------------------------------------------------------------------------
	@GetMapping("/getFeedback/{id}")
	public ResponseEntity<?> getFeedback(@PathVariable("id") int CustId) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		Feedback findFeedbackByCustomer_id = feedbackDao.findSingleByCustId(CustId);
		if (findFeedbackByCustomer_id != null) {
			map.put("status", "success");
			map.put("data", findFeedbackByCustomer_id);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", "error");
			map.put("error", "Feedback Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
		return resp;
	}

	// ---------------------------------------------------------------------------
	// ___________________________Get All Feedback by customer Id
	// ---------------------------------------------------------------------------
	@GetMapping("/getAllFeedback/{id}")
	public ResponseEntity<?> getAllFeedback(@PathVariable("id") int CustId) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		List<Feedback> findFeedbackByCustomer_id = feedbackDao.findByCustId(CustId);
		if (findFeedbackByCustomer_id != null) {
			map.put("status", "success");
			map.put("data", findFeedbackByCustomer_id);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.put("status", "error");
			map.put("error", "Feedback Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	// ---------------------------------------------------------------------------
	// _____________________________Delete Feedback
	// ---------------------------------------------------------------------------

	@DeleteMapping("/deleteFeedback/{id}")
	public ResponseEntity<?> deleteFeedback(@PathVariable(value = "id") int id) throws Exception {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("in delete feedback " + id);

		Feedback feedback = feedbackDao.findById(id)
				.orElseThrow(() -> new Exception("Feedback not found for this id :: " + id));
		try {
			feedbackDao.delete(feedback);
			map.put("status", "success");
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			map.put("error", "Can't delete feedback");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	// ---------------------------------------------------------------------------
	// count
	// ---------------------------------------------------------------------------
	@GetMapping("/AllCount")
	public ResponseEntity<?> getAllCount() {
		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("in vendor count");
		try {
			long vendors = vendorDao.count();
			long employees = employeeDao.count();
			long customers = customerDao.count();
			long serviceRequest = serviceRequestDao.count();

			map.put("status", "success");
			map.put("vendors", vendors);
			map.put("employees", employees);
			map.put("customers", customers);
			map.put("serviceRequest", serviceRequest);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			map.put("error", e.getMessage());
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;

	}

	// ---------------------------------------------------------------------------
	// Get Invoice
	// ---------------------------------------------------------------------------
	@GetMapping("/viewInvoice/{customer_id}")
	public ResponseEntity<?> getInvoiceById(@PathVariable int customer_id) {

		ResponseEntity<?> resp = null;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("in fetch all Customer service request");

		try {
			ServiceRequest service = serviceRequestService.getByCustomerId(customer_id);
			map.put("status", "success");
			map.put("data", service);
			System.out.println("get servicing");
			System.out.println(service);
			resp = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			map.put("status", "error");
			map.put("error", "Customers Not Found");
			resp = new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}
}
