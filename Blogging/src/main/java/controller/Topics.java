package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Topic;


@WebServlet("/topics")
public class Topics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);

		
		con =(Connection) config.getServletContext().getAttribute("dbConn");
		System.out.println("Inside topics serv connected with db...");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {			
		
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * from topic");
			
			List<Topic> list = new ArrayList<Topic>();
			
			while(rs.next()) {
				
				Topic top = new Topic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
				list.add(top);
				
			}
			
			
			request.setAttribute("topics", list);
			
			System.out.println("Data has been set to top");
			
			RequestDispatcher rd = request.getRequestDispatcher("topics.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
