package com.alexa.bank.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.entity.Customer;
import com.alexa.bank.apps.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public void getCustomerByUname(String uname) {
		// TODO Auto-generated method stub
		
	}

}
