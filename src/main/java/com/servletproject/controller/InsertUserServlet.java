package com.servletproject.controller;

import java.io.IOException;

import com.servletproject.dao.UserDAO;
import com.servletproject.model.UserModel;
import com.servletproject.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertUserServlet extends HttpServlet {
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age;
		try {
		 age = Integer.parseInt(req.getParameter("age"));
		}catch(NumberFormatException e) {
		 age = 0;
		}
		
		String error = ValidationUtil.validateUser(name, email, age);
		if(error != null) {
			req.setAttribute("error", error);
			req.getRequestDispatcher("add-user.jsp").forward(req, res);
		}
		
		if(userDao.emailExists(email)) {
			req.setAttribute("error", "Email already exists");
			req.getRequestDispatcher("add-user.jsp").forward(req, res);
			return;
		}
		
		UserModel user = new UserModel(name, email, age);
		userDao.insertUser(user);
		res.sendRedirect("users");
	}
}
