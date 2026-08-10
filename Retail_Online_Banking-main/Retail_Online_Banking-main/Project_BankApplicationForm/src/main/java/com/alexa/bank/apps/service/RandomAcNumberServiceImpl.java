package com.alexa.bank.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.entity.RandomAcNumberGenerator;
import com.alexa.bank.apps.repo.RandomAcNumberRepository;

@Service
public class RandomAcNumberServiceImpl implements RandomAcNumberService {
    
	@Autowired
	private RandomAcNumberRepository randomAcNumberRepository;
	@Override
	public RandomAcNumberGenerator getRandomAcNumberData() {
		
		List<RandomAcNumberGenerator> list = randomAcNumberRepository.findAll();
		return list.get(0);
	}

}
