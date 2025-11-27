package com.listner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ConnectionListener implements ServletContextListener {

	Connection con = null;

	public void contextInitialized(ServletContextEvent sce) {

		ServletContext context = sce.getServletContext();
		String driver = context.getInitParameter("jdbcDriver");
		String url = context.getInitParameter("url");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");

		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("Connection created...");
			
			context.setAttribute("jdbccon", con);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
