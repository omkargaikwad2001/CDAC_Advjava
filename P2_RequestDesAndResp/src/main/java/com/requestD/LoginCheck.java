package com.requestD;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String uid = request.getParameter("uid");
//		String pass = request.getParameter("pass");
//		
//		if(uid.equals("omkar") && pass.equals("omkar123")) {
//			RequestDispatcher rd = request.getRequestDispatcher("/SuccessServlet");
//			rd.forward(request, response);
//		}
//		else {
//			response.sendRedirect("http://localhost:8080/P2_RequestDesAndResp/LoginRD.html");
//		}
//		
//	}
//
//}

	Connection con = null;
	PreparedStatement ps = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb", "root", "root");
			System.out.println("Connection created...");

		} catch (Exception e) {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");

		PrintWriter out = response.getWriter();

		try {
			ps = con.prepareStatement("select * from users where u_id = ? and password = ?");

			ps.setString(1, uid);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("/SuccessServlet");
				rd.forward(request, response);
			} else {
				response.sendRedirect("http://localhost:8080/P2_RequestDesAndResp/LoginRD.html");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
