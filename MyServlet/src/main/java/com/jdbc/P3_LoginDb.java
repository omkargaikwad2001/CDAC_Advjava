package com.jdbc;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/P3_LoginDb")
public class P3_LoginDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","root");
			System.out.println("Connection created...");
			
		}
		catch(Exception e) {
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
		
		PrintWriter out = response.getWriter();
		
		try {
			ps = con.prepareStatement("select * from users where u_id = ? and password = ?");
			
			ps.setString(1, uid);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				out.println("<h1>Login Successfull...</h1>");
				out.println("<h1>Welcome "+uid+"</h1>");
			}
			else {				
				out.println("<h1>Login Failed...</h1>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
