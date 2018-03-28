package com.bank.example.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bank.example.dao.CustomerDao;
import com.bank.example.domain.Customer;

public class CustomerDaoJDBCImpl extends JdbcTemplate implements CustomerDao {

	@Override
	public Customer insert(Customer newCustomer) {
		String insertQuery = " INSERT INTO users(first_name, last_name, dob, email, password, type)  VALUES(?,?,?,?,?,?);";	
		Customer customer = null;
		try (
			PreparedStatement preStmt = conn.prepareStatement(insertQuery)) {						
			preStmt.setString(1, newCustomer.getFirstName());
			preStmt.setString(2, newCustomer.getLastName());
			preStmt.setDate(3, new Date(newCustomer.getDob().getTime()));
			preStmt.setString(4, newCustomer.getEmail());
			preStmt.setString(5, newCustomer.getPassword());
			preStmt.setString(6, newCustomer.getType().name());			
			int rows = preStmt.executeUpdate();
			if (rows > 0) {
				customer = searchByEmail(newCustomer.getEmail());
			}						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer searchById(long id) {
		String selectQuery = "SELECT id, first_name, last_name, dob, email, password FROM users WHERE id=" + id;
		try (
			Statement stmt =  conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery)) {			
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
	
	@Override
	public Customer searchByEmail(String email) {
		String selectQuery = "SELECT id, first_name, last_name, dob, email, password FROM users WHERE email='" + email + "'";
		Customer cus = null;
		try (
			Statement stmt =  conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery)) {	
			if (!rs.next()) {
				return null;
			}
			cus = new Customer();
			cus.setId(rs.getLong("id"));
			cus.setFirstName(rs.getString("first_name"));
			cus.setLastName(rs.getString("last_name"));
			cus.setDob(rs.getDate("dob"));
			cus.setEmail(rs.getString("email"));
			cus.setPassword(rs.getString("password"));			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cus;
	}
	
	@Override
	public Customer searchByEmailAndPassword(String email, String password) {
		String selectQuery = "SELECT id, email, password FROM users WHERE email='" + email + "' AND password='" + password + "'";
		Customer cus = null;
		try (
			Statement stmt =  conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery)) {	
			if (!rs.next()) {
				return null;
			}
			cus = new Customer();
			cus.setId(rs.getLong("id"));
			cus.setEmail(rs.getString("email"));
			cus.setPassword(rs.getString("password"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cus;
	}

}
