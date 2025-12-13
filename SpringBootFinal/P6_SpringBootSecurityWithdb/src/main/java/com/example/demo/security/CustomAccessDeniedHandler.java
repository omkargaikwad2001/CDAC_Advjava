package com.example.demo.security;

import java.io.IOException;

import org.hibernate.annotations.Comment;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.getWriter().write("{\"error\":\"Forbidden\",\"message\":\"No permission to access this resource\"}");

	}

}
