package listner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class JdbcConnection implements ServletContextListener {

    
    public JdbcConnection() {
        
    }

    Connection con=null;
	
    public void contextInitialized(ServletContextEvent sce)  { 
    		
    		ServletContext context = sce.getServletContext();
    		
    		String driver = (String)context.getInitParameter("jdbcDriver");
    		String url = (String)context.getInitParameter("url");
    		String user = (String)context.getInitParameter("user");
    		String pass = (String)context.getInitParameter("pass");
    		
    		try {
				Class.forName(driver);
				System.out.println("Driver loaded...");
				con = DriverManager.getConnection(url,user,pass);
				
				context.setAttribute("dbConn", con);
				
				System.out.println("Connected to db...");
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}    		
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    		
    		try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    }
	
}
