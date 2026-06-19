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

@WebServlet("/search")
public class SearchUserServlet extends HttpServlet {
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String searchString = req.getParameter("searchString");
		List<UserModel> users = userDao.searchUsers(searchString);
		req.setAttribute("users", users);
		req.getRequestDispatcher("user-list.jsp").forward(req, res);
	}
}
