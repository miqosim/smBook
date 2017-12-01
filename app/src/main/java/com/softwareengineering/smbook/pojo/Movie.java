package com.softwareengineering.smbook.pojo;

public class Movie {
	
	//Fields
	
	private int movieId;
	private String name;
	private String director;
	
	//Constructors
	
	public Movie() {
		
	}
	
	public Movie(int movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}

	public Movie(int movieId, String name, String director) {
		this.movieId = movieId;
		this.name = name;
		this.director = director;
	}
	
	//Methods

	public int getMovieId() {
		return this.movieId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public void setMovieId(int id) {
		this.movieId = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDirector(String name) {
		this.director = name;
	}

}
