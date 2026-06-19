package com.servletproject.controller;

import java.io.IOException;
import java.util.List;

import com.servletproject.dao.UserDAO;
import com.servletproject.model.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		HttpSession session = req.getSession(false);
//		if(session == null || session.getAttribute("loggedInUser") == null) {
//			res.sendRedirect("login.jsp");
//			return;
//		}
		List<UserModel> users = userDao.getAllUsers();
		req.setAttribute("users", users);
		req.getRequestDispatcher("user-list.jsp").forward(req, res);
	}
}
