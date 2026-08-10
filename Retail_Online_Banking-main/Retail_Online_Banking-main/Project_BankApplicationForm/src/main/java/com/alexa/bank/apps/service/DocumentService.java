package com.alexa.bank.apps.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
	
	void saveDocument(String uname,MultipartFile file)throws IOException;

}
