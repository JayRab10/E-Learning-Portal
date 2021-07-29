package com.amdocs.training.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/e_learning";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
	

