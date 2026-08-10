package com.alexa.bank.apps.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.entity.AccountDetails;
import com.alexa.bank.apps.repo.CustomerRepository;
import com.alexa.bank.apps.service.AccountDetailsService;

@RestController
public class AccountCreationController {
	
	@Autowired
	private  AccountDetailsService accountDetailsService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping(value ="/createAccount/{uname}")
	public String createAccount(@PathVariable String uname,@RequestBody AccountDetails accountDetails) {
		System.out.println("Check In Controller : " + accountDetails);
		accountDetailsService.createAccount(uname, accountDetails);
		return "Account Created Successfully";
	}
	
	
	@GetMapping("/{id}")
    public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable int id) {
        Optional<AccountDetails> accountDetails = accountDetailsService.getAccountDetailsById(id);
  
        return accountDetails.map(details -> new ResponseEntity<>(details, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	
	@PutMapping("/update/{id}")
    public ResponseEntity<AccountDetails> updateAccountDetails(@PathVariable int id,@RequestBody AccountDetails accountDetails) {
        AccountDetails updatedAccountDetails = accountDetailsService.saveAccountDetails(accountDetails, id);
        return new ResponseEntity<>(updatedAccountDetails, HttpStatus.OK);
    }


	

	
	

}
