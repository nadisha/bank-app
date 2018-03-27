package com.bank.example.dao;

import com.bank.example.domain.Customer;

public interface CustomerDao {
	Customer insert(Customer newCustomer);
	
	Customer searchById(long id);
	
	Customer searchByEmail(String email);
}
