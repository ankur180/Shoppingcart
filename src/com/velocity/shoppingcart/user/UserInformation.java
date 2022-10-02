package com.velocity.shoppingcart.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.velocity.shoppingcart.connection.ConnectionPool;

public class UserInformation {

	//getting all user 
	public void getAllUsers() {
		
		//creating database connection
		ConnectionPool cp = new ConnectionPool();
		try {
			Connection con = cp.getConnectionDemo();
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			 ResultSetMetaData metadata = rs.getMetaData();
	            int columns = metadata.getColumnCount();
	            for (int i = 1; i <= columns; i++) {
	                System.out.print(metadata.getColumnName(i)+"    ");
	               
	            }
			//int i=1;
			
			while(rs.next())
			{
				System.out.printf("%n %5s %10s %15s",rs.getString(1),rs.getString(2),rs.getString(3));
			//i++;
				System.out.println();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	}

