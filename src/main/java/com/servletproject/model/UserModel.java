package com.servletproject.model;

import java.sql.Timestamp;

public class UserModel {
	private int id;
	private String name;
	private String email;
	private int age;
	private Timestamp createdAt;
	
	public UserModel() {}
	
	public UserModel(int id, String name, String email, int age, Timestamp createdAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.createdAt = createdAt;
	}
	
	public UserModel(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
