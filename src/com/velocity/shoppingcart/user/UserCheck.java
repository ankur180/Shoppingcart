package com.velocity.shoppingcart.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.velocity.shoppingcart.connection.ConnectionPool;

//Valid user checking
public class UserCheck {
	
	public void checkValidUser(String s1, String s2) {
		
		//taking database connection
		ConnectionPool cp = new ConnectionPool();
		
		try {
			Connection con = cp.getConnectionDemo();
			PreparedStatement ps = con.prepareStatement("Select user_name,user_password from user");
			ResultSet rs = ps.executeQuery();
			String name=null;
			String pass= null;
			int temp=0;
			while(rs.next()) {
				 name=rs.getString(1);
				 pass=rs.getString(2);
				 if(s1.equals(name) && s2.equals(pass)) {
						temp++;
					}
			}
			
			if(temp>0) {
				System.out.println("Valid user");
				
			}
				else
					System.out.println("Invalid user! check usrname or password");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
