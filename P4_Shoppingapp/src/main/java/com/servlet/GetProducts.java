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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GetProducts")
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;

	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();

		try {
			con = (Connection) servletContext.getAttribute("jdbccon");

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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("HeaderServlet");
		rd.include(request, response);

		// out.print("Products...");

		int cid = Integer.parseInt(request.getParameter("catid"));

		PreparedStatement pstmt = null;

		try {

			pstmt = con.prepareStatement("select * from product where cat_id = ?");

			pstmt.setInt(1, cid);

			ResultSet rs = pstmt.executeQuery();

			out.print("<form action ='addtocart'>");
			out.print("<select name='SelectedProduct'>");
			while (rs.next()) {
				out.print("<option value='" + rs.getInt(1) + "'>" + rs.getString(2) + "</option>");
			}
			out.print("</select>");
			out.print("<input type='submit' value=Add To Cart/>");
			out.print("</form>");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
