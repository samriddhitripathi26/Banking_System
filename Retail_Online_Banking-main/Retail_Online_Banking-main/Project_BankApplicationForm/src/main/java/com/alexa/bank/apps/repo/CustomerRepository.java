package com.alexa.bank.apps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alexa.bank.apps.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByUnameAndPassword(String uname, String pass);
	
	@Query("select uname from Customer")
	List<String> getAllUname();
	
	Customer findByUname(String uname);
	
	Customer findById(int id);

}
