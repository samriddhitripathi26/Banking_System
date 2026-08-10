package com.alexa.bank.apps.service;

import com.alexa.bank.apps.entity.Customer;

public interface CustomerService {
	
	void saveCustomer(Customer customer);
	
	void getCustomerByUname(String uname);

}
