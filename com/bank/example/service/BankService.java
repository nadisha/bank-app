package com.bank.example.service;

import java.util.List;

import com.bank.example.domain.Bank;

public interface BankService {
	List<Bank> findAll();
	
	Bank findByCode(List<Bank> banks, String code);
}
