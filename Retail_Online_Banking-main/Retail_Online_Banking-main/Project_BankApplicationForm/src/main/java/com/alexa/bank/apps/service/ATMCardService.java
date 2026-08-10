package com.alexa.bank.apps.service;

import com.alexa.bank.apps.entity.ATMCardDetails;

public interface ATMCardService {
	
	void saveATMCardDetails(ATMCardDetails atmCardDetails);
	
	void activateATMCard(ATMCardDetails atmCardDetails);
	
    

}
