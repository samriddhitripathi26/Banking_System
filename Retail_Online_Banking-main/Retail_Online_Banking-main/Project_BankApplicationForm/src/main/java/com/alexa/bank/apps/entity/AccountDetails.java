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
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String accountnumber;
	private String acholdername;
	private String accounttype;
	private String accountcreationdate;
	private String bankname;
	private String bankifsccode;
	private String bankfax;
	private String bankemail;
	private String bankcontactno;
	private String bankbranchname;
	private String bankaddress;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ad_ab_id")
	private List<AccountBalance> accountBalances=new ArrayList<AccountBalance>();
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "atm_card_id", referencedColumnName = "id")
    private ATMCardDetails atmCard;

}
