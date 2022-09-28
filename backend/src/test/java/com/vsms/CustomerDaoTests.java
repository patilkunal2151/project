package com.vsms;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.vsms.dao.CustomerDao;
import com.vsms.pojos.Customer;

@SpringBootTest
class CustomerDaoTests {

	@Autowired
	private CustomerDao cdao;

	@Test
	void testFindAll() {
		List<Customer> list = cdao.findAll();
		list.forEach(System.out::println);
	}

	@Test
	void testFindById() {
		Customer cust= cdao.findById(1);
		System.out.println("Cust found by id : "+cust);
	}
	
	@Test
	void testFindByEmail() {
		Customer cust= cdao.findByEmail("abc@gmail.com");
		System.out.println("Customer Found by Email is :"+cust);
	}
	
	@Rollback(false)
	@Transactional
	@Test
	void testSave() {
		Customer cust= new Customer(0,"Dhanashree", "Patil","dhanashree@gmail.com","dhanashree","1122334455","Bhusawal", "MH", "Jalgaon", 3, "Cat");
		cdao.save(cust);
		//System.out.println("Customer Found by Email is :"+cust);
	}
	
}
