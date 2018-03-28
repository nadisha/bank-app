package com.bank.example.ui.console;

import java.util.Scanner;

import com.bank.example.domain.Customer;
import com.bank.example.exception.AlreadyExistException;
import com.bank.example.exception.AuthenticationFailException;
import com.bank.example.exception.DateException;
import com.bank.example.ui.MainMenuItem;

public class MainMenuUI {
	private Scanner scanner;
	
	public MainMenuUI(Scanner sc) {
		this.scanner = sc;
	}
	
	public void loadMainMenu() throws Exception{
	    boolean continueApp = true;
	    do {
	    	showMainMenu();
		    System.out.print("\nPleace choose a number: ");
		    int mainMenuSelection = scanner.nextInt();
		    switch (MainMenuItem.values()[mainMenuSelection - 1]) {
				case REGISTER:
					continueApp = register();
					break;
				case LOGIN:
					login();
					break;
				case FORGOT_PASSWORD:
					forgotPassword();
					break;
				case EXIT:
					exit();		
					continueApp = false;
					break;
				default:
					continueApp = false;
					break;
			}
	    } while (continueApp);
	}
	
	private void showMainMenu() {
	    System.out.println("=========== MAIN MENU ==============");
	    System.out.println("1. Register");
	    System.out.println("2. Login");
	    System.out.println("3. Forgot Password");
	    System.out.println("4. Exit");		
	}
	
	private boolean register() throws DateException, AlreadyExistException{
		RegistrationUI register = new RegistrationUI(this.scanner);
		boolean likeToLogin = register.showRegistrationForm();
		if (likeToLogin) {
			try {
				String loginUserEmail = login();
				dashboard(loginUserEmail);
			} catch (AuthenticationFailException ex) {
				System.out.println("ERROR => " + ex.getMessage());
			}
		} 
		
		return Boolean.TRUE;
	}
	
	private String login() throws AuthenticationFailException{
		LoginUI login = new LoginUI(this.scanner);
		return login.showLogin();
	}
	
	private void dashboard(String loginUserEmail) {
		DashboardUI dashboard = new DashboardUI(scanner);
		dashboard.loadDashboard(loginUserEmail);
	}
	
	private void forgotPassword() {
		// TODO
	}
	
	private void exit() {
		// TODO
	}
}
