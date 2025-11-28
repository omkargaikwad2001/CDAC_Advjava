package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int pid = Integer.parseInt(request.getParameter("SelectedProduct"));
		HttpSession session= request.getSession();
		List<Integer> cartlist =  (List<Integer>)session.getAttribute("cart");
		if(cartlist == null) {
			cartlist = new ArrayList<>();
		}
		cartlist.add(pid);
		session.setAttribute("cart", cartlist);
		out.print("<p>"+pid+" is added to the cart </p>");
		out.print("<p> There are total "+cartlist.size()+" products in the cart<p>");
		out.print("<br/><a href='HomeServlet'> Select more </a>");
		out.print("<br/><a href='viewcart'> View Cart </a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
