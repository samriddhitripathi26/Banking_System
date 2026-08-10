package com.alexa.bank.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.entity.LoanDetails;
import com.alexa.bank.apps.service.LoanDetailsService;
@RestController
public class LoanDetailsController {
	
	@Autowired
	private LoanDetailsService loanDetailsService;
	
	@PostMapping(value = "/applyLoan/{uname}")
	public String loanDetails(@PathVariable String uname,@RequestBody LoanDetails loanDetails) {
		System.out.println("Check In Controller" + loanDetails+uname);
		loanDetailsService.saveLoanDetails(loanDetails);
		return "Your Loan application is successfully submitted...";
	}	
	
	

}
