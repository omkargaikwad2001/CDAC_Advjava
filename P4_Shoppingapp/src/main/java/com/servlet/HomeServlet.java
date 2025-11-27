package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		
		ServletContext servletContext = config.getServletContext();
		
		try {			
			con = (Connection)servletContext.getAttribute("jdbccon");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		RequestDispatcher rd = request.getRequestDispatcher("HeaderServlet");
		rd.include(request, response);
		
		PrintWriter out = response.getWriter();
		//		out.print("Hello");
		Statement stmt=null;
		ResultSet rs=null;
		try {
			 stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from category");
			
			while(rs.next()) {
				
				out.print("<a href='GetProducts?catid="+rs.getInt(1)+"'>"+rs.getString(2)+"</a><br>");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
