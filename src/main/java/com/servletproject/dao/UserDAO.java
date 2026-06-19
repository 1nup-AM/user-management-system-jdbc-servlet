package com.servletproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servletproject.model.UserModel;
import com.servletproject.util.DBConnection;
import com.servletproject.util.PasswordUtil;

public class UserDAO {
	public List<UserModel> getAllUsers(){
		List<UserModel> users = new ArrayList<>();
		String sql = "Select * from users";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));
				user.setCreatedAt(rs.getTimestamp("created_at"));
				
				users.add(user);
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return users;
	}
	
	public void insertUser(UserModel user) {
		String sql = "insert into users(name, email, age) values (?, ?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getAge());
			pstmt.executeUpdate();
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(UserModel user) {
		String sql = "update users set name = ?, email = ?, age = ? where id = ?";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getAge());
			pstmt.setInt(4, user.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int id) {
		String sql = "delete from users where id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserModel getUserById(int id) {
		UserModel user = null;
		String sql = "select * from users where id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setAge(rs.getInt("age"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean emailExists(String email) {
		String sql = "Select count(*) from users where email = ?";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) > 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validateAdminLogin(String email, String password) {
		String sql = "Select * from admins where email = ? and password = ?";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			String hashedPassword = PasswordUtil.hashPassword(password);
			pstmt.setString(1, email);
			pstmt.setString(2, hashedPassword);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<UserModel> searchUsers(String searchString){
		List<UserModel> users = new ArrayList<>();
		String sql = "select * from users where lower(name) like ? or lower(email) like ?";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			String search = "%" + searchString.toLowerCase() + "%";
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				
				users.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
