package com.alexa.bank.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexa.bank.apps.entity.Accountbalmaster;

@Repository
public interface AccountBalMasterRepository extends JpaRepository<Accountbalmaster, Integer>{
	
	Accountbalmaster findByUnameAndActype(String uname,String type);

}
