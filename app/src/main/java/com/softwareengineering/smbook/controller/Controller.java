package com.softwareengineering.smbook.controller;

import com.softwareengineering.smbook.jdbc.Connect;
import com.softwareengineering.smbook.pojo.Cinema;
import com.softwareengineering.smbook.pojo.Hall;
import com.softwareengineering.smbook.pojo.Movie;
import com.softwareengineering.smbook.pojo.MovieScreening;
import com.softwareengineering.smbook.pojo.Seat;
import com.softwareengineering.smbook.pojo.Ticket;
import com.softwareengineering.smbook.pojo.User;

import java.util.ArrayList;

public class Controller {
	
	//Fields
	
	private ArrayList<Cinema> cinemas;
	private ArrayList<Hall> halls;
	private ArrayList<Movie> movies;
	private ArrayList<MovieScreening> screening;
	private ArrayList<Seat> seats;
	private ArrayList<Ticket> tickets;
	private ArrayList<User> users;
	
	// Fill Cinemas array data from database
	
	public void fillCinemas() throws Exception{
		cinemas = Connect.INSTANCE.getCinemaList();
	}
	
	// Fill Hall array data from database
	
	public void fillHalls() throws Exception{
		halls = Connect.INSTANCE.getHallList();
	}
	
	// Fill Movie array data from database
	
	public void fillMovies() throws Exception{
		movies = Connect.INSTANCE.getMovieList();
	}
	
	// Fill Movie Screening array data from database
	
	public void fillMovieScreening() throws Exception{
		screening = Connect.INSTANCE.getScreeningList();
	}
	
	// Fill Seat array data from database
	
	public void fillSeatList() throws Exception{
		seats = Connect.INSTANCE.getSeatList();
	}
	
	// Fill Tickets array data from database
	
	public void fillTicketList() throws Exception{
		tickets = Connect.INSTANCE.getTicketsList();
	}
	
	// Fill Users array data from database
	
	public void fillTUserist() throws Exception{
		users = Connect.INSTANCE.getUserList();
	}
	
	//Cinema Catalog methods
	
	public Cinema getCinemaById(int id) {
		for(Cinema i:cinemas) {
			if(i.getCinemaId() == id) {
				return i;
			}
		}
		return null;
	}
	
	// Add cinema into cinemas list
	
	public void addCinema(Cinema c) {
		cinemas.add(c);
	}
	
	//Remove cinema from a list
	
	
	public void removeCinema(Cinema c) {
		cinemas.remove(c);
	}
	
	//Remove cinema from a list by ID
	
	public void removeCinemaById(int id) {
		for(Cinema i:cinemas) {
			if(i.getCinemaId() == id)
				cinemas.remove(i);
		}
	}
	

	
	//Halls Catalog methods
	
	public Hall getHallById(int id) {
		for(Hall i:halls) {
			if(i.getHallId() == id) {
				return i;
			}
		}
		return null;
	}
	

	
	public void addHall(Hall c) {
		halls.add(c);
	}
	
	
	
	public void removeHall(Hall c) {
		halls.remove(c);
	}
	
	public void removeHallById(int id) {
		for(Hall i:halls) {
			if(i.getHallId() == id)
				halls.remove(i);
		}
	}
	
	//Movies Catalog methods
	
	public Movie getMovieById(int id) {
		for(Movie i:movies) {
			if(i.getMovieId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void addMovie(Movie c) {
		movies.add(c);
	}
	
	public void removeMovie(Movie c) {
		movies.remove(c);
	}
	
	public void removeMovieById(int id) {
		for(Movie i:movies) {
			if(i.getMovieId() == id)
				movies.remove(i);
		}
	}
	
	
	// Movie Screening Catalog methods
	
	public Seat getSeatById(int id) {
		for(Seat i:seats) {
			if(i.getSeatId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void addSeat(Seat c) {
		seats.add(c);
	}
	
	public void removeSeat(Seat c) {
		seats.remove(c);
	}
	
	public void removeSeatById(int id) {
		for(Seat i:seats) {
			if(i.getSeatId() == id)
				seats.remove(i);
		}
	}

	
	// Seats Catalog methods
	
	public MovieScreening getMovieScreeningById(int id) {
		for(MovieScreening i:screening) {
			if(i.getMovieScreeningID() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void addMovieScreening(MovieScreening c) {
		screening.add(c);
	}
	
	public void removeMovieScreening(MovieScreening c) {
		screening.remove(c);
	}
	
	public void removeMovieScreeningById(int id) {
		for(MovieScreening i:screening) {
			if(i.getMovieScreeningID() == id)
				screening.remove(i);
		}
	}



	// Tickets Catalog methods
	
	public Ticket getTicketById(int id) {
		for(Ticket i:tickets) {
			if(i.getTicketId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void addMTicket(Ticket c) {
		tickets.add(c);
	}
	
	public void removeTicket(Ticket c) {
		tickets.remove(c);
	}
	
	public void removeTicketById(int id) {
		for(Ticket i:tickets) {
			if(i.getTicketId() == id)
				tickets.remove(i);
		}
	}


	// User Catalog methods
	
	public User getUserById(int id) {
		for(User i:users) {
			if(i.getUserId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void addUser(User c) {
		users.add(c);
	}
	
	public void removeUser(User c) {
		users.remove(c);
	}
	
	public void removeUseryId(int id) {
		for(User i:users) {
			if(i.getUserId() == id)
				users.remove(i);
		}
	}	
}
