package com.bank.example.service;

import com.bank.example.domain.Bank;

public interface AccountService {
	long generateNextAccountNumber(Bank bank);
}
