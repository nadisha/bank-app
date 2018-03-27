package com.bank.example.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bank.example.config.JDBCConfiguration;

public class JdbcTemplate {
	protected static Connection conn;
	
	static {
		
		String url = String.format("%s/%s", JDBCConfiguration.CONNECTION_URL, JDBCConfiguration.DB_NAME);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			if (conn == null) {
				conn = DriverManager.getConnection(url, JDBCConfiguration.USERNAME, JDBCConfiguration.PASSWORD);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("ERROR => " + e.getMessage());
		}		
	}
	
	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
