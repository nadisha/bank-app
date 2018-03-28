package com.bank.example.dao;

import java.util.List;

import com.bank.example.domain.Account;

public interface AccountDao {
	List<Account> searchByBank(long bankId);
}
