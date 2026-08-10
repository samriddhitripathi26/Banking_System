package com.alexa.bank.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexa.bank.apps.entity.AccountDetails;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetails, Integer> {
	
	AccountDetails findByAccountnumberAndAccounttype(String acno,String actype);
	
//	AccountDetails findByAccountnumber(String acnumber);

}
