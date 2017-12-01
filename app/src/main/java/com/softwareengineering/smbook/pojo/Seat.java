package com.softwareengineering.smbook.pojo;

public class Seat {
	
	//Fields
	
	private int seatId;
	private int row;
	private int place;
	private int hallId;
	
	//Constructors
	
	public Seat() {
	}

	public Seat(int seatId, int row, int place, int hallId) {
		this.seatId = seatId;
		this.row = row;
		this.place = place;
		this.hallId = hallId;
	}
	
	//Methods

	public int getSeatId() {
		return seatId;
	}
	
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getPlace() {
		return place;
	}
	
	public void setPlace(int place) {
		this.place = place;
	}
	
	public int getHallId() {
		return hallId;
	}
	
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	
}
