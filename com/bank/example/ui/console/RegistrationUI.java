package com.bank.example.ui.console;

import java.util.Scanner;

import com.bank.example.config.ApplicationConfiguration;
import com.bank.example.domain.Customer;
import com.bank.example.exception.AlreadyExistException;
import com.bank.example.exception.DateException;
import com.bank.example.service.CustomerService;
import com.bank.example.service.impl.CustomerServiceImpl;

public class RegistrationUI {
	private Scanner scanner;
	
	private CustomerService customerService;
	
	public RegistrationUI(Scanner sc) {
		this.scanner = sc;
		this.customerService = new CustomerServiceImpl();
	}
	
	private Customer getCustomerDetails() throws DateException{
		Customer customer = new Customer();
	    System.out.println("\n=========== 1. REGISTRATION ==============");
	    System.out.print("First Name: ");
	    String fName = scanner.next();
	    customer.setFirstName(fName);
	    
	    System.out.print("Last Name: ");
	    customer.setLastName(scanner.next());
	    System.out.print(String.format("Date Of Birth (%s): ", ApplicationConfiguration.DATE_FORMAT));
	    String dob = scanner.next();	    
		customer.setDob(dob, ApplicationConfiguration.DATE_FORMAT);
		
	    System.out.print("Email (as username): ");
	    customer.setEmail(scanner.next());
	    System.out.print("Password: ");
	    customer.setPassword(scanner.next());	    
	    return customer;
	}
	
	public boolean showRegistrationForm() throws DateException, AlreadyExistException{
		Customer customer = getCustomerDetails();
		if (customer != null)  {
			// Persist customer details in the database
			// Throw AlreadyExistException if a customer exist with same email address
			customerService.save(customer);
		}
		System.out.print("\nDo you want to login (y/n) ?");
		String option = scanner.next();
		return option.equalsIgnoreCase("Y");
	}
}
