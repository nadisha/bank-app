package com.bank.example.ui.console;

import java.util.Scanner;

import com.bank.example.domain.Customer;

public class LoginUI {
	private Scanner scanner;
	
	public LoginUI(Scanner sc) {
		this.scanner = sc;
	}
	
	private Customer authenticate() {
		Customer customer = new Customer();
		System.out.println("\n=========== 2. LOGIN ==============");
		System.out.print("Username: ");
		customer.setEmail(scanner.next());
		System.out.print("Password: ");
		customer.setPassword(scanner.next());
		// Pass the username and password and get customer details from the database
		// Throw, AuthenticationFailException if the customer record is not found.
		return customer;
	}
	
	public boolean showLogin() {
		authenticate();
		return Boolean.TRUE;
	}
}
