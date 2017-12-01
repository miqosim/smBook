package com.softwareengineering.smbook.pojo;

import java.util.Date;

public class User {
	
	//Fields
	
	private int userId;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Date birthday;
	
	//Constructors
	
	public User() {
	}
	
	public User(int userId, String name, String email, String password, Date birthday) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
	}

	public User(int userId, String name, String email, String password) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(int userId, String name, String surname, String email, String password) {
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	public User(int userId, String name, String surname, String email, String password, Date birthday) {
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
	}
	
	//Methods

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
