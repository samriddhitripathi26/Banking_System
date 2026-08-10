package com.alexa.bank.apps.exception;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alexa.bank.apps.entity.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseBody
	public ExceptionResponse handleException(AccountNotFoundException exception,HttpServletRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setErrormsg(exception.getMessage());
		exceptionResponse.setUri(request.getRequestURI());
		return exceptionResponse;
		
	}

}
