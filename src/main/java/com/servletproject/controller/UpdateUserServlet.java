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

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		UserModel user = new UserModel();
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age;
		try { age = Integer.parseInt(req.getParameter("age")); }
		catch(NumberFormatException e) {age = 0;}
		
		String error = ValidationUtil.validateUser(name, email, age);
		if(error != null) {
			req.setAttribute("error", error);
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setAge(age);
			
			req.setAttribute("user", user);
			req.getRequestDispatcher("edit-user.jsp").forward(req, res);
			return;
		}
		
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setAge(age);
		userDao.updateUser(user);
		res.sendRedirect("users");
	}
}
