package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/viewcart")
public class ViewCart extends HttpServlet {
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
		
		HttpSession session = request.getSession();
		List<Integer> cartlist = (List<Integer>)session.getAttribute("cart");
		if(cartlist == null) {
			out.print("<p> No products are selected </p>");
		}
		else {
			String query = "select * from product where p_id= ?";
			PreparedStatement ps = null;
			ResultSet rs =null;
			try {
				ps = con.prepareStatement(query);
				out.println("<table border=1>");
				float total = 0;
				for(int n : cartlist) {
					ps.setInt(1, n);
					rs = ps.executeQuery();
					rs.next();
					out.print("<tr>");
					out.print("<td>"+ rs.getString(2)+ "</td>");
					out.print("<td>"+ rs.getString(3)+ "</td>");
					total += rs.getFloat(4);
					out.print("<td>"+ rs.getFloat(4) + "</td>");
					out.print("<td>  <a href='DeleteCartServlet?pid="+n+"'>delete</a> </td>");
					out.print("</tr>");
				}
				out.print("<tr>");
				out.print("<td colspan=2>Total price </td>");
				out.print("<td>"+total+"</td>");
				out.print("</tr>");				
				out.print("</table>");
				session.setAttribute("tprice", total);
				out.print("<br/><br/><a href='HomeServlet'> Select more </a>");
				out.print("<br/><br/><a href='confirmcart'> Confirm Cart </a>");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
