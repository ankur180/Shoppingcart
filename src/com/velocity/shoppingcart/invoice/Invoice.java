package com.velocity.shoppingcart.invoice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.velocity.shoppingcart.connection.ConnectionPool;
import com.velocity.shoppingcart.products.ReduceProduct;

//Invoice generation
public class Invoice {
	// for fetching database connection
	ConnectionPool cp = new ConnectionPool();

	static int productId;
	static double total;
	static String name;
	static int quantity;
	static String activeUser;

	public static String getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(String activeUser) {
		Invoice.activeUser = activeUser;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	Connection con = null;

	//checking total amount for purchased product
	public double getInvoice(int num, int quantity) throws Exception {
		ReduceProduct rp = new ReduceProduct();

		con = cp.getConnectionDemo();
		Statement stm;
		stm = con.createStatement();
		String sql = "Select * From products where prod_id=" + num;
		ResultSet rst;
		rst = stm.executeQuery(sql);
		double val = 0.0d;
		String name = "";
		double total = 0.0d;
		while (rst.next()) {
			val = rst.getDouble(3);
			name = rst.getString(4);
		}
		total = val * quantity;
		this.name = name;
		this.total = total;
		this.quantity = quantity;

		return val * quantity;
	}

	public void getValues(int num) {
		this.productId = num;
	}

	//reteive the current user
	public void getActiveUser(String name) {
		this.setActiveUser(name);
	}
	//Generating invoice
	public void printInvoice() throws Exception {
		System.out.println("User name:" + this.getActiveUser());
		System.out.println("You have Purchase: " + this.name);
		System.out.println("Number of quantity : " + this.quantity);
		System.out.println(" Total Amount : " + this.total);
	}

}
