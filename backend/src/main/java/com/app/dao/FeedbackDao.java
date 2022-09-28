package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

	@Query(value = "SELECT * FROM Feedback WHERE customer_id = ?1" , nativeQuery = true)
	List<Feedback> findByCustId(int custId);
	
	@Query(value = "SELECT * FROM Feedback WHERE customer_id = ?1 order by id DESC limit  1" , nativeQuery = true)
	Feedback findSingleByCustId(int custId);
}
