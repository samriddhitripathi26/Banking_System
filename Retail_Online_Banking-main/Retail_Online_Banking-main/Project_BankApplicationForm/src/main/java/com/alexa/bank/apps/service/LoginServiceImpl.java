package com.alexa.bank.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.dto.CustomerResponse;
import com.alexa.bank.apps.entity.Customer;
import com.alexa.bank.apps.repo.CustomerRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerResponse getLoginData(String uname, String pass) {
		
		CustomerResponse customerResponse = new CustomerResponse();
		
		Customer customer = customerRepository.findByUnameAndPassword(uname, pass);
		if(customer != null) {
			customerResponse.setId(customer.getId());
			customerResponse.setFname(customer.getFirstName());
			customerResponse.setLname(customer.getLastName());
			customerResponse.setUname(customer.getUname());
			if(customer.getRole() != null) {
			customerResponse.setRolename(customer.getRole().getRoleName());
			}
		}
		return customerResponse;
		
	}
		

}
