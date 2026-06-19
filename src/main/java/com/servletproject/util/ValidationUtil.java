package com.servletproject.util;

public class ValidationUtil {
	public static String validateUser(String name, String email, int age) {
		if(name == null || name.trim().isEmpty())
			return "Name cannot be empty";
		
		if(email == null || email.trim().isEmpty())
			return "Email cannot be empty";
		
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
			return "Invalid email format";
		
		if(age < 0 || age > 100)
			return "Age must be between 0 and 100";
		
		return null;
	}
}
