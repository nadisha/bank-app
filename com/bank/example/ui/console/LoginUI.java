package com.bank.example.ui.console;

import java.util.Scanner;

import com.bank.example.domain.Customer;
import com.bank.example.exception.AuthenticationFailException;
import com.bank.example.service.CustomerService;
import com.bank.example.service.impl.CustomerServiceImpl;

public class LoginUI {
	private Scanner scanner;
	
	private CustomerService customerService;
	
	public LoginUI(Scanner sc) {
		this.scanner = sc;
		customerService = new CustomerServiceImpl();
	}
	
	private boolean authenticate() throws AuthenticationFailException{
		Customer customer = new Customer();
		System.out.println("\n=========== 2. LOGIN ==============");
		System.out.print("Username: ");
		customer.setEmail(scanner.next());
		System.out.print("Password: ");
		customer.setPassword(scanner.next());
		// Pass the username and password and get customer details from the database
		// Throw, AuthenticationFailException if the customer record is not found.
		boolean isAuthenticated = customerService.authenticate(customer.getEmail(), customer.getPassword());
		return isAuthenticated;
	}
	
	public boolean showLogin() throws AuthenticationFailException{
		return authenticate();
	}
}
