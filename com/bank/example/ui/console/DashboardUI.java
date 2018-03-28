package com.bank.example.ui.console;

import java.util.List;
import java.util.Scanner;

import com.bank.example.domain.Account;
import com.bank.example.domain.AccountType;
import com.bank.example.domain.Bank;
import com.bank.example.domain.Customer;
import com.bank.example.service.BankService;
import com.bank.example.service.CustomerService;
import com.bank.example.service.impl.BankServiceImpl;
import com.bank.example.service.impl.CustomerServiceImpl;
import com.bank.example.ui.DashboardMenuItem;

public class DashboardUI {
	private Scanner scanner;	
	private Customer accountHolder;	
	private CustomerService customerService;	
	private BankService bankService;
	
	public DashboardUI(Scanner sc) {
		this.scanner = sc;
		customerService = new CustomerServiceImpl();
		bankService = new BankServiceImpl();
	}
	
	private void showCustomerDashboard() {		
		System.out.println("\n=========== MY DASHBOARD ==============");
		System.out.println("1. Create Account");
		System.out.println("2. Search Account");
		System.out.println("3. List my accounts");
		System.out.println("4. Withdraw");
		System.out.println("5. Deposit");
		System.out.println("6. Transfer");
		System.out.println("7. Logout");
	}
	
	public void loadDashboard(String loginUserEmail) {
		accountHolder = customerService.findByEmail(loginUserEmail);
		boolean continueDashboard = Boolean.TRUE;
		do {
			showCustomerDashboard();
		    System.out.print("\nPleace select your option: ");
		    int dashboardSelection = scanner.nextInt();
		    switch(DashboardMenuItem.values()[dashboardSelection - 1]) {
		    	case CREATE_ACCOUNT:
		    		createAccount();
		    		break;
		    	case SEARCH_ACCOUNT:
		    		searchAccount();
		    		break;
		    	case LIST_ACCOUNT:
		    		listAccount();
		    		break;
		    	case WITHDRAW:
		    		withdraw();
		    		break;
		    	case DEPOSIT:
		    		deposit();
		    		break;
		    	case TRANSFER:
		    		transfer();
		    		break;
		    	case LOGOUT:
		    		logout();
		    		break;
		    }
		} while(continueDashboard);
	}
	
	private void createAccount() {
		System.out.println("\n=========== MY DASHBOARD - CREATE ACCOUNT ==============");
		Account account = new Account();
		account.setAccountHolder(accountHolder);
		// List the banks
		List<Bank> availableBanks = bankService.findAll();
		StringBuffer bankList = new StringBuffer();
		for(Bank b : availableBanks) {
			bankList.append(b.getName()).append(" - ").append(b.getCode()).append("\n");
		}
		System.out.println("Available Banks");
		System.out.println(bankList);
		System.out.print("\nEnter your 3 digit bank code: ");
		String code = scanner.next();
		Bank selectedBank = bankService.findByCode(availableBanks, code);
		account.setBank(selectedBank);
		
		// List the account types
		StringBuffer accountList = new StringBuffer();
		for (AccountType accType : AccountType.values()) {
			accountList.append(accType.name()).append("\n");
		}
		System.out.println("Available Account Types");
		System.out.println(accountList);
		System.out.print("\nEnter the account type you wish to create: ");		
		String accountType = scanner.next();
		account.setAccountType(AccountType.valueOf(accountType));		
		
		// Ask to provide initial deposit amount to create a new account
		System.out.print("Initial deposit amount: ");
		float depositAmount = scanner.nextFloat();
		account.setBalance(depositAmount);
		
	}
	
	private void searchAccount() {
		System.out.println("\n=========== MY DASHBOARD - SEARCH ACCOUNT ==============");
	}
	
	private void listAccount() {
		System.out.println("\n=========== MY DASHBOARD - LIST ACCOUNT ==============");		
	}
	
	private void withdraw() {
		System.out.println("\n=========== MY DASHBOARD - WITHDRAW ==============");
	}
	
	private void deposit() {
		System.out.println("\n=========== MY DASHBOARD - DEPOSIT ==============");
	}
	
	private void transfer() {
		System.out.println("\n=========== MY DASHBOARD - TRANSFER ==============");
	}
	
	private void logout() {
		
	}
}
