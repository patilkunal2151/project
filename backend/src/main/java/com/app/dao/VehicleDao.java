package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

	@Query(value = "select * from Vehicle where customerId = ?1", nativeQuery = true)
	public Vehicle findByCustomerId(int id);

	List<Vehicle> findAll();
	

}
