package com.vsms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsms.pojos.Vendor;

public interface VendorDao extends JpaRepository<Vendor, Integer> {

	Vendor findByEmail(String email);

	List<Vendor> findAll();

	Vendor findByVid(int id);

}
