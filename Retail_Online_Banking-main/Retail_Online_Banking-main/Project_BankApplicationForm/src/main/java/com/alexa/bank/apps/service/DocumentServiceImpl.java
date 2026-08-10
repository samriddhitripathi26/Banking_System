package com.alexa.bank.apps.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alexa.bank.apps.entity.Customer;
import com.alexa.bank.apps.entity.DocumentDetails;
import com.alexa.bank.apps.repo.CustomerRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void saveDocument(String uname, MultipartFile file) throws IOException {
		Customer customer = customerRepository.findByUname(uname);
		if(customer != null) {
			DocumentDetails documentDetails = new DocumentDetails();
			documentDetails.setDocName(file.getOriginalFilename());
			documentDetails.setDocSize(file.getSize());
			documentDetails.setDocData(file.getBytes());
			customer.getDocumentDetails().add(documentDetails);
			customerRepository.save(customer);
		}else {
			System.out.println("Customer Not found.");
		}
		
	}

}
