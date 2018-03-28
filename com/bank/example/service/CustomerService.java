package com.bank.example.service;

import com.bank.example.domain.Customer;
import com.bank.example.exception.AlreadyExistException;
import com.bank.example.exception.AuthenticationFailException;

public interface CustomerService {
	Customer save(Customer newCustomer) throws AlreadyExistException;
	
	Customer findById(long id);
	
	Customer findByEmail(String email);
	
	boolean authenticate(String username, String password) throws AuthenticationFailException;
}
