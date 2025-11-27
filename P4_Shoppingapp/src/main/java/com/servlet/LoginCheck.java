package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	PreparedStatement ps = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {

			ServletContext servletContext = config.getServletContext();
			con = (Connection) servletContext.getAttribute("jdbccon");
			System.out.println("Using con inside servlet...");

		} catch (Exception e) {
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
				
				User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				Cookie[] cookies = request.getCookies();

				if (cookies != null) {
				    for (Cookie ck : cookies) {
				        if (ck.getName().equals("loginFailed")) {
				            ck.setMaxAge(0);
				            ck.setValue("");
				            response.addCookie(ck);
				        }
				    }
				}


				ps = con.prepareStatement("INSERT INTO logs (userid, logintime) VALUES (?,?)");
				ps.setString(1, uid);
				ps.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
				
				ps.execute();

				RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
				rd.forward(request, response);
				

			} else {
				Cookie c = new Cookie("loginFailed", "Wrong_PWD_UID");
				response.addCookie(c);
//				response.sendRedirect("http://localhost:8080/P4_Shoppingapp/Login.html");
				response.sendRedirect("http://localhost:8080/P4_Shoppingapp/Login.jsp");
//				out.println("Login Failed...");
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
