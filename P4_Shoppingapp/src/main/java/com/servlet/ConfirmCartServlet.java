package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/confirmcart")
public class ConfirmCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = config.getServletContext();		
		con = (Connection)context.getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		
		//add one record in the shoppingtable
		//uid, current date time, total price
		 HttpSession session = request.getSession();
		 User user = (User)session.getAttribute("user");
		 String uid = user.getUid();
		 float total = (Float)session.getAttribute("tprice");
		 String query = "insert into shopping(user_id, shoppingDate, totalprice) values(?, current_timestamp(), ?)";
		 PreparedStatement ps = null;
		 try {
			 ps = con.prepareStatement(query);
			 ps.setString(1, uid);
			 ps.setFloat(2, total);
			 int  n = ps.executeUpdate();
			 if(n == 1) {
				 out.print("<p> Order is conformed </p>");
				 out.print("<p> Bill will be mailed at "+user.getEmail()+" </p>");
				 out.print("<p> You will receive the message on "+user.getContact()+" before delivery</p>");
				 out.print("<br/><br/><a href='LogoutServlet'> Logout </a>");
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
			 try {
				ps.close();
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		 }
		 
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
