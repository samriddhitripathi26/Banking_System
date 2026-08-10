package com.alexa.bank.apps.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerResponse {
	
	private int id;
	
	private String fname;
	
	private String lname;
	
	private String uname;
	
	private String rolename;
	
	

}
