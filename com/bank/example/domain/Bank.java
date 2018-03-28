package com.bank.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String name;
	private long accountNoStartFrom;
	private long accountNoEndFrom;
	private String address;
	private List<Account> accounts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccountNoStartFrom() {
		return accountNoStartFrom;
	}
	public void setAccountNoStartFrom(long accountNoStartFrom) {
		this.accountNoStartFrom = accountNoStartFrom;
	}
	public long getAccountNoEndFrom() {
		return accountNoEndFrom;
	}
	public void setAccountNoEndFrom(long accountNoEndFrom) {
		this.accountNoEndFrom = accountNoEndFrom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		if (accounts == null) {
			accounts = new ArrayList<>();
		}
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
