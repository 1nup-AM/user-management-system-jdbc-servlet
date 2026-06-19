package com.servletproject.dao;

import java.util.List;

import com.servletproject.model.UserModel;

public class DAOTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		List<UserModel> users = dao.getAllUsers();
//		List<UserModel> users = dao.searchUsers("rudo");
		for(UserModel user : users) {
			System.out.println(
					user.getId() + " "
					+ user.getName() + " "
					+ user.getEmail()
			);
		}
	}
}
