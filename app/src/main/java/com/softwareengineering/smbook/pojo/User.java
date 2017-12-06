package com.softwareengineering.smbook.pojo;

import java.util.Date;

public class User {
	
	//Fields
	
	private int userId;
//	private String name;
//	private String surname;
//	private String email;
	private String username;
	private String password;
//	private Date birthday;
	
	//Constructors

	public User(){

	}


	public User(String username, String password) {
//		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	public User(int userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
