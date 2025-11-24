package com.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P7_ScrollableAndUpdatable {
	

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/knowit","root","root");
		
		Statement stmt =  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		ResultSet rs = stmt.executeQuery("select * from emp2");
		
		while (rs.next()) {
            System.out.println("old record " +
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getFloat(3));

            float sal = rs.getFloat(3);
            float usalary = sal;

            if (sal < 1000) {
                usalary = sal + sal * 0.02f;
            } else if (sal >= 1000 && sal < 2500) {
                usalary = sal + sal * 0.05f;
            } else if (sal >= 2500 && sal < 5000) {
                usalary = sal + sal * 0.08f;
            } else if (sal >= 5000) {
                usalary = sal + sal * 0.10f;
            }

            rs.updateFloat(3, usalary);

            rs.updateRow();

            System.out.println("new record " +
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getFloat(3));
        }

        con.close();
    }
}