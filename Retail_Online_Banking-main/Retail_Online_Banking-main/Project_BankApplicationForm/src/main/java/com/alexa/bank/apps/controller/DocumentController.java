package com.alexa.bank.apps.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alexa.bank.apps.service.DocumentService;
@RestController
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
		
	@GetMapping(value = "/upload/{uname}")
	public String saveDocumentData(@PathVariable String uname,@RequestParam MultipartFile file) {
		System.out.println("Multipart File Name :" + file.getOriginalFilename() + "  " + file.getSize());
		try {
			documentService.saveDocument(uname, file);
		} catch (IOException e) {
			
			e.getMessage();
		}
		return "Document Uploaded Successfuly.";
	}

}
