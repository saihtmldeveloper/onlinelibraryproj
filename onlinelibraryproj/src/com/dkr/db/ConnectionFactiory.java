package com.dkr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactiory {
	public static Connection con;
	static {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "dinesh";
			String password = "dinesh";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		
	}
	
	public static Connection getConnection() {
		
		return con;
	}
}
