package com.softwareengineering.smbook.jdbc;


import com.softwareengineering.smbook.pojo.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
	
public enum Connect {
	
	INSTANCE;
	
	//Connect to database
	private Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "ikjlkftg");
	}
	
	//Close connection with database
	private void closeConnection(Connection connection) {
		if(connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}
	
	//Get result set of a table from database
	
	private ResultSet getTableData(String tablename) {
		ResultSet result = null;
		String sql = "select * from " + tablename;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			result = statement.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}
	
	// Get Tickets list from database
	
	public ArrayList<Ticket> getTicketsList() throws SQLException {
		ResultSet result = getTableData("Ticket");
		ArrayList<Ticket> tickets = new ArrayList<>(); 
		while(result.next()) {
			try {
					Ticket ticket = new Ticket();
					ticket.setMovieScreeningId(result.getInt("MovieScreeningId"));
					ticket.setSeatId(result.getInt("TicketId"));
					ticket.setTicketId(result.getInt("TicketId"));
					tickets.add(ticket);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return tickets;
	}
	
	// Get Users list from database
	
	public ArrayList<User> getUserList() throws SQLException {
		ResultSet result = getTableData("User");
		ArrayList<User> users= new ArrayList<>();
		while(result.next()) {
			try {
				User user = new User();
				user.setBirthday(result.getDate("Date_Of_Birth"));
				user.setEmail(result.getString("Email"));
				user.setName(result.getString("Name"));
				user.setPassword("Password");
				user.setSurname(result.getString("Surname"));
				user.setUserId(result.getInt("UserId"));
				users.add(user);
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return users;
	}
	
	// Get Seats list from database
	
	public ArrayList<Seat> getSeatList() throws SQLException{
		ResultSet result = getTableData("Seat");
		ArrayList<Seat> seats = new ArrayList<>();
			while(result.next()) {
				try {
					Seat seat = new Seat();
					seat.setHallId(result.getInt("Hall"));
					seat.setPlace(result.getInt("Place"));
					seat.setRow(result.getInt("Row"));
					seat.setSeatId(result.getInt("SeatId"));
					seats.add(seat);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return seats;
	}
	
	// Get Movie Screening list from database
	
	public ArrayList<MovieScreening> getScreeningList() throws SQLException {
		ResultSet result = getTableData("MovieScreening");
		ArrayList<MovieScreening> moviesScreening = new ArrayList<>();
			while(result.next()) {
				try {
				MovieScreening screening = new MovieScreening();
				screening.setMovieScreeningId(result.getInt("MovieScreeningId"));
				screening.setDateTime(result.getDate("Date_and_Time"));
				screening.setMovieId(result.getInt("Movie"));
				moviesScreening.add(screening);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
			return moviesScreening;
	}
	
	// Get Movies list from database
	
	public ArrayList<com.softwareengineering.smbook.pojo.Movie> getMovieList() {
		ResultSet result = getTableData("Movie");
		ArrayList<com.softwareengineering.smbook.pojo.Movie> movies= new ArrayList<>();

				try {
					while(result.next()) {
						com.softwareengineering.smbook.pojo.Movie movie = new Movie();
						movie.setDirector(result.getString("Director"));
						movie.setMovieId(result.getInt("MovieId"));
						movie.setName(result.getString("Name"));
						movies.add(movie);
					}
				} catch(SQLException ex) {
					ex.printStackTrace();
				}

			return movies;		
	}
	
	// Get Halls list from database
	
	public ArrayList<Hall> getHallList() throws SQLException {
		ResultSet result = getTableData("Hall");
		ArrayList<Hall> halls= new ArrayList<>();
			while(result.next()) {
				try {
					Hall hall = new Hall();
					hall.setCinemaId(result.getInt("Cinema"));
					hall.setHallId(result.getInt("HallId"));
					hall.setName(result.getString("Name"));
					halls.add(hall);
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			return halls;
	}
	
	// Get Cinemas list from database
	
	public ArrayList<Cinema> getCinemaList() throws SQLException{
		ResultSet result = getTableData("Cinema");
		ArrayList<Cinema> cinemas = new ArrayList<>();
			while(result.next()) {
				try {
					Cinema cinema = new Cinema();
					cinema.setAdress(result.getString("Address"));
					cinema.setId(result.getInt("CinemaID"));
					cinema.setLatitude(result.getInt("Latitude"));
					cinema.setName(result.getString("Name"));
					cinemas.add(cinema);
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			return cinemas;
		}
}
