package com.velocity.shoppingcart.connection;

import java.sql.Connection;
import java.sql.DriverManager;


//Creating connecting to the database
public class ConnectionPool {
	public Connection getConnectionDemo() throws Exception {
		// connecting to database
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart", "root", "root");
		return con;
	}
}
