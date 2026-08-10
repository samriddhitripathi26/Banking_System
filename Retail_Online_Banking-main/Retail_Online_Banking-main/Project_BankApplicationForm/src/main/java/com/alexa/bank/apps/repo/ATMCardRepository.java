package com.alexa.bank.apps.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexa.bank.apps.entity.ATMCardDetails;

@Repository
public interface ATMCardRepository extends JpaRepository<ATMCardDetails, Integer> {
	
	Optional<ATMCardDetails> findByAtmcardnumber(long atmCardNumber);

}
