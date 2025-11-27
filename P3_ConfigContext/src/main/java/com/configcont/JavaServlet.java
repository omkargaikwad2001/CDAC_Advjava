package com.configcont;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
		urlPatterns = { "/JavaServlet" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "java")
		})
public class JavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		String subject = config.getInitParameter("subject");
		
//		ServletContext servletContext = request.getServletContext();
//		String insti = servletContext.getInitParameter("Institute");
		
		ServletContext context = getServletContext();
		String insti = context.getInitParameter("Institute");
		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>subject = "+subject+" Institute = "+insti+"</h1>");
		
	}

}
