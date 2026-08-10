package com.alexa.bank.apps.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.dto.Balance;
import com.alexa.bank.apps.entity.AccountBalance;
import com.alexa.bank.apps.entity.AccountDetails;
import com.alexa.bank.apps.entity.Accountbalmaster;
import com.alexa.bank.apps.entity.Customer;
import com.alexa.bank.apps.entity.RandomAcNumberGenerator;
import com.alexa.bank.apps.repo.AccountBalMasterRepository;
import com.alexa.bank.apps.repo.AccountDetailRepository;
import com.alexa.bank.apps.repo.CustomerRepository;
import com.alexa.bank.apps.repo.RandomAcNumberRepository;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	private AccountDetailRepository accountDetailRespository;

	@Autowired
	private RandomAcNumberService randomAcNumberService;

	@Autowired
	private RandomAcNumberRepository ramdomAcNumberRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private AccountBalMasterRepository accountBalMasterRepository;

	@Override
	public void createAccount(String uname, AccountDetails accountDetails) {
		System.out.println("Account Creation Start");
		if(accountDetails != null && uname != null) {
			Customer customer = customerRepository.findByUname(uname);
			if(customer != null) {
				RandomAcNumberGenerator randomAcNumberGenerator = randomAcNumberService.getRandomAcNumberData();
				//Accountbalmaster accountbalmaster = accountBalMasterRepository.findById(1).get();
				accountDetails.setAccountnumber("SBI/GEN:"+String.valueOf(randomAcNumberGenerator.getAcnumber()));
				accountDetails.setAcholdername(customer.getFirstName()+ " "+customer.getLastName());
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");
				String date = dateFormat.format(new Date(System.currentTimeMillis()));
				
				accountDetails.setAccountcreationdate(date);
				accountDetails.getAccountBalances().get(0).setTxtDate(date);
				accountDetails.getAccountBalances().get(0).setUname(uname);
//				List<AccountBalance> accountBalances = accountDetails.getAccountBalances();
//				for(AccountBalance ab : accountBalances) {
//					ab.setTxtDate(date);
//					ab.setUname(uname);
//				}
				
				customer.getAccountDetails().add(accountDetails);
				Customer customer2 = customerRepository.save(customer);
				Accountbalmaster accountbalmaster = new Accountbalmaster();
				accountbalmaster.setUname(uname);
				accountbalmaster.setTotalBalance(accountDetails.getAccountBalances().get(0).getBalance());
				accountbalmaster.setActype(accountDetails.getAccounttype());
				accountBalMasterRepository.save(accountbalmaster);
				if(customer2 != null) {
					//Mail trigger --> AccountNumber Total Balance
					SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
					simpleMailMessage.setTo("amivits3@gmail.com");
					simpleMailMessage.setText("Check mail Triggering.");
					//javaMailSender.send(simpleMailMessage);
					long acnumber = randomAcNumberGenerator.getAcnumber()+1;
					System.out.println("Check ac number : " + acnumber);
					randomAcNumberGenerator.setAcnumber(acnumber);
					ramdomAcNumberRepository.save(randomAcNumberGenerator);
				}
			}else {
				System.out.println("Customer Not found.");
			}
		}
		System.out.println("Account Creation End.");


	}

	@Override
	public Optional<AccountDetails> getAccountDetailsById(int id) {

		return accountDetailRespository.findById(id);
	}

	@Override
	public AccountDetails saveAccountDetails(AccountDetails accountDetails, int id) {

		return accountDetailRespository.save(accountDetails);

	}

	@Override
	public String creditBalance(String uname, String acno, Balance balance) {
		String acNo = "SBI/"+acno;
		String msg = "";
		if(acno != null) {
			Accountbalmaster accountbalmaster = accountBalMasterRepository.findByUnameAndActype(uname, balance.getAccounttype());
			AccountDetails accountDetails = accountDetailRespository.findByAccountnumberAndAccounttype(acNo,balance.getAccounttype());
			if(accountDetails != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");
				String date = dateFormat.format(new Date(System.currentTimeMillis()));
				AccountBalance accountBalance = new AccountBalance();
				accountBalance.setTxtDate(date);
				accountBalance.setUname(uname);
//				accountDetails.getAccountBalances().setTxtupdateDate(date);
//				accountDetails.getAccountBalances().setUname(uname);
				if(balance.getCreditAmount() > 0) {
					double totalBalance = accountbalmaster.getTotalBalance();
					double aftertransactionbalnce = totalBalance+balance.getCreditAmount();
					//accountDetails.getAccountBalance().setCreditamount(balance.getCreditAmount());
					//accountDetails.getAccountBalance().setBalance(totalBalance+balance.getCreditAmount());
					accountBalance.setCreditamount(balance.getCreditAmount());
					accountBalance.setBalance(aftertransactionbalnce);
					accountDetails.getAccountBalances().add(accountBalance);
					accountDetailRespository.save(accountDetails);
					accountbalmaster.setTotalBalance(aftertransactionbalnce);
					accountbalmaster.setActype(balance.getAccounttype());
					accountbalmaster.setUname(uname);
					accountBalMasterRepository.save(accountbalmaster);
					msg = "Credit";
				}
				if(balance.getDebitAmount() > 0) {
					double totalBalance = accountbalmaster.getTotalBalance();
					double aftertransactionbalnce = totalBalance-balance.getDebitAmount();
					//accountDetails.getAccountBalance().setDeductamount(balance.getDebitAmount());
		            //accountDetails.getAccountBalance().setBalance(totalBalance-balance.getDebitAmount());
		            accountDetailRespository.save(accountDetails);
		            accountBalance.setDeductamount(balance.getDebitAmount());
					accountBalance.setBalance(aftertransactionbalnce);
					accountDetails.getAccountBalances().add(accountBalance);
					accountDetailRespository.save(accountDetails);
					accountbalmaster.setTotalBalance(aftertransactionbalnce);
					accountbalmaster.setActype(balance.getAccounttype());
					accountbalmaster.setUname(uname);
					accountBalMasterRepository.save(accountbalmaster);
					msg = "Debit";
				}
			}else {
				return "Account Details not found.";
			}
		}else {
			return "Account Not Exists.";
		}
		return msg+" Successfully";
	}

}
