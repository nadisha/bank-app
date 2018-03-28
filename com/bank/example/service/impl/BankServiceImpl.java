package com.bank.example.service.impl;

import java.util.List;

import com.bank.example.dao.BankDao;
import com.bank.example.dao.jdbc.BankDaoJDBCImpl;
import com.bank.example.domain.Bank;
import com.bank.example.service.BankService;

public class BankServiceImpl implements BankService {

	private BankDao bankDao;
	
	public BankServiceImpl() {
		bankDao = new BankDaoJDBCImpl();
	}
	
	@Override
	public List<Bank> findAll() {
		return bankDao.getAll();
	}

	@Override
	public Bank findByCode(List<Bank> banks, String code) {
		for (Bank bank : banks) {
			if (bank.getCode().equalsIgnoreCase(code)) {
				return bank;
			}
		}
		return null;
	}
}
