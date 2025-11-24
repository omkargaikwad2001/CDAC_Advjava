package com.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P8_Transaction {

	public static void main(String[] args) throws Exception{

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowit", "root", "root");
		
		con.setAutoCommit(false);
		
		try {
			
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("insert into sinfo values(102,'omkar2','omkar2@gmail.com','8856234578','pune2');");
			System.out.println("First query executed...");
//			stmt.executeUpdate("insert into squalification values(79.79,60.60,7.3)");
//			for roll back
			stmt.executeUpdate("insert into squalificatio values(79.79,60.60,7.3)");
			System.out.println("Second query executed...");
			
			con.commit();
			System.out.println("All data commited");
			
		} catch (Exception e) {
			con.rollback();
			System.out.println("Data roll backed...");
			
		}
		
		con.setAutoCommit(true);
		


	}

}
