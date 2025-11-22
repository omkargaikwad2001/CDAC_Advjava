package com.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P4_DisplayEmp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Driver loaded...");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowit","root","root");
			
			
//			Q4 to display employee details (empno taken by user)
//			System.out.println("Enter EMPNO : ");
//			int id = sc.nextInt();
//			
//			PreparedStatement ps = con.prepareStatement("select * from emp where empno = ?");
//			ps.setInt(1, id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
//			}
//			else {
//				System.out.println("Emp not found");
//			}
			
//			Q5 accept min sal and max sal from user and show employees btn
			
			System.out.println("Enter min sal");
			int min = sc.nextInt();
			
			System.out.println("Enter max sal");
			int max = sc.nextInt();
			
			PreparedStatement ps = con.prepareStatement("select * from emp where sal > ? and sal < ?");
			
			ps.setInt(1, min);
			ps.setInt(2, max);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(6));
				}
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
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
