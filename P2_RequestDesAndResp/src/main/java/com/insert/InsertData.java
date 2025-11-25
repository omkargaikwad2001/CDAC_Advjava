package com.insert;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded...");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","root");
			System.out.println("Connected...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String uid = request.getParameter("uid");
	    String pass = request.getParameter("pass");
	    String fname = request.getParameter("fname");
	    String mname = request.getParameter("mname");
	    String lname = request.getParameter("lname");
	    String mail = request.getParameter("mail");
	    String contact = request.getParameter("contact");


	    PreparedStatement ps = null;
			
	    try {
	        ps = con.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)");
	        ps.setString(1, uid);
	        ps.setString(2, pass);
	        ps.setString(3, fname);
	        ps.setString(4, mname);
	        ps.setString(5, lname);
	        ps.setString(6, mail);
	        ps.setString(7, contact);

	        int result = ps.executeUpdate(); 

	        if(result > 0) {
	            System.out.println("Data inserted successfully...");
	        } else {
	            System.out.println("Insert failed...");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(ps != null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
