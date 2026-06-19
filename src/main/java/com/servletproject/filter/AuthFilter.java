package com.servletproject.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
	
	@Override
	public void doFilter(HttpServletRequest req	, HttpServletResponse res, FilterChain chain ) throws IOException, ServletException {
		String path = req.getRequestURI();
		boolean isLoginRequest = path.endsWith("login") || path.endsWith("login.jsp") || path.endsWith("logout");
		HttpSession session = req.getSession(false);
		boolean loggedIn = session != null && session.getAttribute("loggedInUser") != null ;
		if(loggedIn || isLoginRequest) {
			chain.doFilter(req, res);
		} else {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}
}
