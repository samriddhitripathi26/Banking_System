package com.alexa.bank.apps.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ExceptionResponse {

	private String errormsg;

	private String uri; // Uniform Resource Identifier (URI). The URI must contain the correct connection information to successfully call the API.

	
	
     
	
	
}
