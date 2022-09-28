package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer> {
	
	
	 
	
	List<Stock> findByQuantity(int quantity); 
	

}
