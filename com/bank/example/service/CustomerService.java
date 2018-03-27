package com.bank.example.service;

import com.bank.example.domain.Customer;
import com.bank.example.exception.AlreadyExistException;

public interface CustomerService {
	Customer save(Customer newCustomer) throws AlreadyExistException;
	
	Customer findById(long id);
	
	Customer findByEmail(String email);
}
