package com.alexa.bank.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.entity.Customer;
import com.alexa.bank.apps.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/save")
	public String saveCustomer(@RequestBody Customer customer) {
		System.out.println("Check In Controller : " + customer);
		customerService.saveCustomer(customer);
		return "success";
	}
	


}
