package com.alexa.bank.apps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Loan")
public class LoanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String adharCard;
	private String panCard;
	private String perAddr;
	private String currAddr;
	private long contactNo;
	private String offEmailId;
	private String officeAddr;
	private String perEmailId;
	private double salary;
	private String loanType;
	private double loanAmount;
	private int tenour;
	private double monthlyEMI;
	
	
	private String status;

}
