package com.alexa.bank.apps.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ATMCardDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String atmcardholdername;
	private String acnumber;
	private String expirydate;
	private String password;
	private long atmcardnumber;
	private int cvv;
	
	@Type(type="yes_no")
	private boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "atm_bal_id")
	private List<AccountBalance> accountBalances =new ArrayList<AccountBalance>();
	
	
	
	

}
