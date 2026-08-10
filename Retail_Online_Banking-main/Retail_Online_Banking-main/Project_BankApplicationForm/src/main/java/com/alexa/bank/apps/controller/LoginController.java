package com.alexa.bank.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.dto.CustomerResponse;
import com.alexa.bank.apps.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value="/login/{uname}/{pass}")
	public CustomerResponse getLoginData(@PathVariable String uname,@PathVariable String pass) {
		System.out.println("Login Credentials : "+ uname + " "+ pass);
		CustomerResponse customerResponse = loginService.getLoginData(uname, pass);
		
		return customerResponse;
	}

}
