package com.bank.example.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bank.example.config.ApplicationConfiguration;
import com.bank.example.exception.DateException;

public class Customer extends User{	
	private Set<Account> accounts;
	
	public Customer() {
		setType(UserType.CUSTOMER);
	}

	public Set<Account> getAccounts() {
		if (accounts == null) {
			accounts = new HashSet<>();
		}
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void setDob(String birthDate, String pattern) throws DateException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			Date date = simpleDateFormat.parse(birthDate);
			setDob(date);
		} catch (ParseException e) {
			String message = String.format("Input date formate is incorrect. The format should be %s", ApplicationConfiguration.DATE_FORMAT);
			throw new DateException(message);
		}
	}
}
