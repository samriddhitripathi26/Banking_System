package com.alexa.bank.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.dto.Balance;
import com.alexa.bank.apps.service.AccountDetailsService;

@RestController
public class AccountBalanceController {

	@Autowired
	private AccountDetailsService accountDetailsService;

	@PostMapping(value = "/creditbalance/{uname}/SBI/{acno}")
	public String creditAmount(@PathVariable String uname, @PathVariable String acno, @RequestBody Balance balance) {
		System.out.println("Balance Check : " + acno + "  " + balance);
		String str = accountDetailsService.creditBalance(uname, acno, balance);
		return str;

	}

}
