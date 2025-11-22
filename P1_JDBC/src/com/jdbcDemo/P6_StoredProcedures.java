package com.jdbcDemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class P6_StoredProcedures {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Driver loaded...");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowit","root","root");
		
		Scanner sc = new Scanner(System.in);
//		Q6
		
//		System.out.println("Enter EMPNO ");
//		int eno = sc.nextInt();
//		
//		System.out.println("Enter Percentage ");
//		int per = sc.nextInt();
//		
//		CallableStatement call = con.prepareCall("{call updateSal(?,?)}");
//		
//		call.setInt(1, eno);
//		call.setInt(2, per);
//		
//		int executeUpdate = call.executeUpdate();
//		
//		if(executeUpdate>0) {
//			System.out.println("Data updated...");
//		}
//		else {
//			System.out.println("Something went wrong...");			
//		}
		
//		Q7
		
		System.out.println("Enter Deptno ");
		int deptno = sc.nextInt();
		
		
		CallableStatement call = con.prepareCall("{call empInfo(?,?,?)}");
		call.setInt(1, deptno);
		
		call.registerOutParameter(2, java.sql.Types.VARCHAR);
		call.registerOutParameter(3, java.sql.Types.FLOAT);
		
		call.execute();
		
		System.out.println(call.getString(2));
		System.out.println(call.getFloat(3));
		
		sc.close();
		con.close();

	}

}
