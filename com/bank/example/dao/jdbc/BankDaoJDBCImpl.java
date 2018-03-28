package com.bank.example.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.example.dao.BankDao;
import com.bank.example.domain.Bank;

public class BankDaoJDBCImpl extends JdbcTemplate implements BankDao {
	
	@Override
	public List<Bank> getAll() {
		String selectQuery = "SELECT id, name, code, initialAccountNumber, address FROM BANK ORDER BY name";
		List<Bank> banksList = new ArrayList<>();
		try (
			Statement stmt =  conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery)) {
			while(rs.next()) {
				Bank bank = new Bank();
				bank.setId(rs.getLong("id"));
				bank.setName(rs.getString("name"));
				bank.setCode(rs.getString("code"));
				bank.setInitialAccountNumber(rs.getLong("initialAccountNumber"));
				bank.setAddress(rs.getString("address"));
				banksList.add(bank);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return banksList;
	}
}
