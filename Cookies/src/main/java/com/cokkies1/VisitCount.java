package com.cokkies1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/VisitCount")
public class VisitCount extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		response.setContentType("text/html");
    	
        PrintWriter out = response.getWriter();
        int count = 0;

        // Read existing cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie ck : cookies) {
                if(ck.getName().equals("visitCount")) {
                    count = Integer.parseInt(ck.getValue());
                }
            }
        }

        // Increment visit count
        count++;

        // Create new cookie with updated count
        Cookie c = new Cookie("visitCount", Integer.toString(count));
        
        c.setMaxAge(3);
        
        response.addCookie(c);

        out.print("You have visited this page " + count + " times.");
        
        out.print("<a href='VisitCount'>REFRESH</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
