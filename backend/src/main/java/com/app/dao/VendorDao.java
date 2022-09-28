package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;;

@Repository
public interface VendorDao extends JpaRepository<Vendor, Integer> {

	Vendor findByEmailAndPassword(String email, String password);

	Vendor findByEmail(String email);

	List<Vendor> findAll();

	List<Vendor> findByAddress(String address);

}
