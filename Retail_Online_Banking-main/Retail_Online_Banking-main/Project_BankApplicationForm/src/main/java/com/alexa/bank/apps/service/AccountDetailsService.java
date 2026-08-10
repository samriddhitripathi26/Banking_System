package com.alexa.bank.apps.service;

import java.util.Optional;

import com.alexa.bank.apps.dto.Balance;
import com.alexa.bank.apps.entity.AccountDetails;

public interface AccountDetailsService {
	void createAccount(String uname, AccountDetails accountDetails);
	
	public Optional<AccountDetails> getAccountDetailsById(int id);
	
	public AccountDetails saveAccountDetails(AccountDetails accountDetails,int id);
	
	
	String creditBalance(String uname,String acno,Balance balance);
	

	
}
