package com.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class P1_Connecting {

	public static void main(String[] args) {
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Driver loaded...");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowit","root","root");
			
			System.out.println("Connected to db successfully...");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
