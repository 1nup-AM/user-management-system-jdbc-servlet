package com.servletproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.servletproject.dao.UserDAO;
import com.servletproject.model.UserModel;


@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		UserModel user = userDao.getUserById(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher("edit-user.jsp").forward(req, res);
	}

}
