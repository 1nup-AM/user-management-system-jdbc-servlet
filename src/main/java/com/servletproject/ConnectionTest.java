package com.servletproject;

import java.sql.Connection;

import com.servletproject.util.DBConnection;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection con = DBConnection.getConnection();
		if(con!=null)
			System.out.println("DB Connected");
		else
			System.out.println("Connection Failed");
	}
}
