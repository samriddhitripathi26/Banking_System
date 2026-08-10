package com.alexa.bank.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexa.bank.apps.entity.RandomAcNumberGenerator;

public interface RandomAcNumberRepository extends JpaRepository<RandomAcNumberGenerator, Integer>{

}
