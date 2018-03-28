package com.bank.example.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bank.example.dao.AccountDao;
import com.bank.example.domain.Account;
import com.bank.example.domain.Customer;

public class AccountDaoJDBCImpl extends JdbcTemplate implements AccountDao {

	@Override
	public List<Account> searchByBank(long bankId) {
		String selectQuery = "SELECT id, createdDate, accountNumber, balance, accountType FROM accounts WHERE bank_id = ?";
		try (
			PreparedStatement preStmt =  conn.prepareStatement(selectQuery)) {
			preStmt.setLong(1, bankId);
			ResultSet rs = preStmt.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));

			}
				Customer cus = new Customer();
				cus.setId(rs.getLong("id"));
				cus.setFirstName(rs.getString("first_name"));
				cus.setLastName(rs.getString("last_name"));
				cus.setDob(rs.getDate("dob"));
				cus.setEmail(rs.getString("email"));
				cus.setPassword(rs.getString("password"));
				return cus;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
	}

}
