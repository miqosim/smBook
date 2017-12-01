package com.softwareengineering.smbook.pojo;

import java.util.Date;

public class MovieScreening {
	
	//Fields
	
	private int movieScreeningId;
	private int movieId;
	private Date dateTime;
	
	//Constructors
	
	public MovieScreening() {
		
	}
	
	
	public MovieScreening(int movieScreeningId, int movieId, Date dateTime) {
		this.movieScreeningId = movieScreeningId;
		this.movieId = movieId;
		this.dateTime = dateTime;
	}
	
	//Methods

	public int getMovieScreeningID() {
		return this.movieScreeningId;
	}
	
	public int getMovieId() {
		return this.movieId;
	}
	
	public Date getDate() {
		return this.dateTime;
	}
	
	public void setMovieScreeningId(int id) {
		this.movieScreeningId = id;
	}
	
	public void setMovieId(int id) {
		this.movieId = id;
	}
	
	public void setDateTime(Date date) {
		this.dateTime = date;
	}

}
