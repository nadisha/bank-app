package com.bank.example;

import java.util.Scanner;

import com.bank.example.ui.console.MainMenuUI;

public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MainMenuUI mainMenu = new MainMenuUI(scanner);
		try {
			mainMenu.loadMainMenu();
		} catch (Exception e) {
			System.out.println("ERROR => " + e.getMessage());
			e.printStackTrace();
		}
	}
}
