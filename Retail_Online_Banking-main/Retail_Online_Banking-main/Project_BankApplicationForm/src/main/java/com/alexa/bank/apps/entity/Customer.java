package com.alexa.bank.apps.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String motherName;
	private long contactNo;
	private String gender;
	private String dateOfBirth;
	private String emailId;
	private String adharCard;
	private String panCard;
	private String identificationMark;
	private String address;
	private String occupation;
	private String uname;
	private String password;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="c_r_id")
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_acc_id")
	private List<AccountDetails> accountDetails = new ArrayList<AccountDetails>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cust_loan_id")
	private LoanDetails loan;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_doc_id")
	private List<DocumentDetails> documentDetails =new ArrayList<DocumentDetails>();
	
	
	

}
