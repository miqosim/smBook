package com.softwareengineering.smbook.pojo;
public class Hall {
	
	//Fields
	
	private int hallId;
	private String name;
	private int cinemaId;
	
	
	//Constructors

	public Hall(int hallId, int cinemaId) {
		this.hallId = hallId;
		this.cinemaId = cinemaId;
	}

	public Hall(int hallId, String name, int cinemaId) {
		this.hallId = hallId;
		this.name = name;
		this.cinemaId = cinemaId;
	}
	
	public Hall() {
		
	}
	
	//Methods

	public int getHallId() {
		return this.hallId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCinemaId() {
		return this.cinemaId;
	}
	
	public void setHallId(int id) {
		this.hallId = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCinemaId(int id) {
		this.cinemaId = id;
	}
}
