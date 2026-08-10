package com.alexa.bank.apps.service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.entity.ATMCardDetails;
import com.alexa.bank.apps.repo.ATMCardRepository;

@Service
public class ATMCardServiceImpl implements ATMCardService{
	
	@Autowired
	private ATMCardRepository atmCardRepository;

	@Override
	public void saveATMCardDetails(ATMCardDetails atmCardDetails) {
		System.out.println("In ATM Card Service : " + atmCardDetails);
		atmCardDetails.setActive(true);
		long smallest = 1000_0000_0000_0000L;
		long biggest = 9999_9999_9999_9999L;
		
		long smallest1= 001L;
		long biggest1=999L;
		
		// return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
		long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
		long random1 = ThreadLocalRandom.current().nextLong(smallest1, biggest1+1);
		System.out.println(random + "   " + random1);
		atmCardDetails.setAtmcardnumber(random);
		atmCardDetails.setCvv((int)random1);
		atmCardRepository.save(atmCardDetails);
		
	}

	@Override
	public void activateATMCard(ATMCardDetails atmCardDetails) {
		
		ATMCardDetails atmCardDetails2 = null;
		
		Optional<ATMCardDetails> optional=atmCardRepository.findByAtmcardnumber(atmCardDetails.getAtmcardnumber());
		if(optional.isPresent()) {
			atmCardDetails2 =optional.get();
			atmCardDetails2.setPassword(atmCardDetails.getPassword());
			atmCardRepository.save(atmCardDetails2);
		}
		
	}
	
	

}
