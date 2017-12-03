package com.softwareengineering.smbook.pojo;
public class Ticket {
	
	//Fields
	
	private int ticketId;
	private int seatId;
	private int movieScreeningId;
	
	
	//Constructors
	
	public Ticket() {
		
	}
	
	public Ticket(int ticketId, int seatId, int movieScreeningId) {
		this.ticketId = ticketId;
		this.seatId = seatId;
		this.movieScreeningId = movieScreeningId;
	}
	
	//Methods

	public int getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public int getSeatId() {
		return seatId;
	}
	
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	
	public int getMovieScreeningId() {
		return movieScreeningId;
	}
	
	public void setMovieScreeningId(int movieScreeningId) {
		this.movieScreeningId = movieScreeningId;
	}
	
	

}
