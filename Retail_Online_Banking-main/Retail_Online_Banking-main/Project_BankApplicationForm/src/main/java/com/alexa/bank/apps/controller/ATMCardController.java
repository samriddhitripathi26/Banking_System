package com.alexa.bank.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.entity.ATMCardDetails;
import com.alexa.bank.apps.service.ATMCardService;

@RestController
public class ATMCardController {
	@Autowired
	private ATMCardService atmCardService;
	
	@PostMapping(value = "/atmcard/save")
	public ResponseEntity<String> saveATMCardData(@RequestBody ATMCardDetails atmCardDetails) {
		System.out.println("In ATM Controller ATM Card Data : " + atmCardDetails);
		atmCardService.saveATMCardDetails(atmCardDetails);
		return new ResponseEntity<String>("ATM Card Generated Successfully.",HttpStatus.CREATED);
	}
		
	@PostMapping(value = "/atmcard/active")
	public ResponseEntity<String> activateATMCard(@RequestBody ATMCardDetails atmCardDetails ) {
		System.out.println("ATM Card number : " + atmCardDetails);
		atmCardService.activateATMCard(atmCardDetails);
		return new ResponseEntity<String>("ATM Card Activated Successfully.",HttpStatus.OK);
		
	}
	
	

}
