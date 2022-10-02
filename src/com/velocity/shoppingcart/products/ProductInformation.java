package com.velocity.shoppingcart.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

import com.velocity.shoppingcart.connection.ConnectionPool;

public class ProductInformation {

	public void getProducts(){
		//creating connection to database
		ConnectionPool cp = new ConnectionPool();
		try {
			Connection con = cp.getConnectionDemo();
			PreparedStatement ps = con.prepareStatement("select * from products");
			ResultSet rs = ps.executeQuery();
			 ResultSetMetaData metadata = rs.getMetaData();
	            int columns = metadata.getColumnCount();
	            for (int i = 3; i <= columns; i++) {
	                System.out.print(metadata.getColumnName(i)+"    ");
	               
	            }
			// formating table 
			while(rs.next())
			{
				System.out.printf("%n %5s %10s %15s",rs.getString(3),rs.getString(4),rs.getString(5));
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
