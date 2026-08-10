package com.alexa.bank.apps.service;

import com.alexa.bank.apps.dto.CustomerResponse;

public interface LoginService {
	
	CustomerResponse getLoginData(String uname,String pass);
		
	

}
