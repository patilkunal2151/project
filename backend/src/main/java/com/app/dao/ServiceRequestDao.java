package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.ServiceRequest;

@Repository
public interface ServiceRequestDao extends JpaRepository<ServiceRequest, Integer>{
	
	Optional<ServiceRequest> findByCustomerId(int customer_id);

	Optional<ServiceRequest> findByRequestId(int request_id);
	
	List<ServiceRequest> findAllByCustomerId(int customerId); 
	
	Optional<ServiceRequest> findByVendorId(int vendorId);
	
	List<ServiceRequest> findAllByVendorId(int vendorId); 
	
	Optional<ServiceRequest> findByCustomerIdAndStatus(int customer_id,String status);
}
