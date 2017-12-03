package com.softwareengineering.smbook.pojo;
public class Cinema {
	
	//Fields
	
	private int cinemaId;
	private String name;
	private String address;
	private int latitude;
	
	//Constructors
	
	public Cinema(int id, String name, String address, int lat) {
		this.address = address;
		this.name = name;
		this.cinemaId = id;
		this.latitude = lat;
	}
	
	public Cinema(int cinemaId, String name) {
		this.cinemaId = cinemaId;
		this.name = name;
	}
	
	public Cinema() {
		
	}

	public Cinema(int cinemaId, String name, String address) {
		this.cinemaId = cinemaId;
		this.name = name;
		this.address = address;
	}
	
	//Methods



	public int getCinemaId() {
		return this.cinemaId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public int getLatitude() {
		return this.latitude;
	}
	
	public void setId(int id) {
		this.cinemaId = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAdress(String address) {
		this.address = address;
	}
	
	public void setLatitude(int lat) {
		this.latitude = lat;
	}
	
}
