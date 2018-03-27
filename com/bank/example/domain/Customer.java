package com.bank.example.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bank.example.config.ApplicationConfiguration;
import com.bank.example.exception.DateException;

public class Customer extends User{

	public Customer() {
		setType(UserType.CUSTOMER);
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
