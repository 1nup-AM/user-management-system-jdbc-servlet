package com.servletproject.controller;

import java.io.IOException;

import com.servletproject.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(userDao.validateAdminLogin(email, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", email);
			res.sendRedirect("users");
		}else {
			req.setAttribute("error", "Invalid Credentials");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
}
