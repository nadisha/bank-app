package com.bank.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private long id;
	private String name;
	private String code;
	private long initialAccountNumber;
	private String address;
	private List<Account> accounts;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getInitialAccountNumber() {
		return initialAccountNumber;
	}
	public void setInitialAccountNumber(long initialAccountNumber) {
		this.initialAccountNumber = initialAccountNumber;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
