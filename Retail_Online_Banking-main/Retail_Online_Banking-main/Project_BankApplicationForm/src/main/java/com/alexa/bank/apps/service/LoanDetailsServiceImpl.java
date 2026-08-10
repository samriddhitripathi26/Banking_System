package com.alexa.bank.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.entity.LoanDetails;
import com.alexa.bank.apps.repo.LoanDetailsRepository;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	private LoanDetailsRepository loanDetailsRepository;

	@Override
	public void saveLoanDetails(LoanDetails loanDetails) {
		loanDetailsRepository.save(loanDetails);
		
	}

	

}
