package com.bank.example.service.impl;

import com.bank.example.dao.CustomerDao;
import com.bank.example.dao.jdbc.CustomerDaoJDBCImpl;
import com.bank.example.domain.Customer;
import com.bank.example.exception.AlreadyExistException;
import com.bank.example.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao dao;
	
	public CustomerServiceImpl() {
		dao = new CustomerDaoJDBCImpl();
	}
	
	@Override
	public Customer save(Customer newCustomer) throws AlreadyExistException{
		Customer customer = findByEmail(newCustomer.getEmail());
		if (customer == null) {
			return dao.insert(newCustomer);
		}
		throw new AlreadyExistException(String.format("User with email [%s] already exist", newCustomer.getEmail()));
	}

	@Override
	public Customer findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Customer findByEmail(String email) {
		return dao.searchByEmail(email);
	}

}
