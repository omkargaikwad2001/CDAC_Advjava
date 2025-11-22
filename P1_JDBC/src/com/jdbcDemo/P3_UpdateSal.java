package com.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P3_UpdateSal {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowit","root","root");
			
			Statement stmt = con.createStatement();
			
			String query = "update emp set SAL = 1000 where EMPNO = 7369";
			
			
			int executeUpdate = stmt.executeUpdate(query);
			
			if(executeUpdate>0) {
				System.out.println("Data updated successfully...");
			}
			else {
				System.out.println("Something went wrong...");
			}
			
			
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
