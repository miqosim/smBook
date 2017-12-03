package com.softwareengineering.smbook.jdbc;

import com.softwareengineering.smbook.pojo.Cinema;
import com.softwareengineering.smbook.pojo.Hall;
import com.softwareengineering.smbook.pojo.Movie;
import com.softwareengineering.smbook.pojo.MovieScreening;
import com.softwareengineering.smbook.pojo.Seat;
import com.softwareengineering.smbook.pojo.Ticket;
import com.softwareengineering.smbook.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public enum Connect {

    INSTANCE;

    //Connect to database
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://193.111.140.223/se_db", "se_db", "ujexparol");
    }

    //Close connection with database

    private void closeConnection(Connection connection) {
        if (connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Get result set of a table from database

    private ResultSet getTableData(String tablename, Connection connection) {
        ResultSet result = null;
        String sql = "select * from " + tablename;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // Get Tickets list from database

    public ArrayList<Ticket> getTicketsList() throws SQLException, ClassNotFoundException {
        Connection connection = Connect.INSTANCE.getConnection();
        ResultSet result = getTableData("Ticket", connection);
        ArrayList<Ticket> tickets = new ArrayList<>();
        while (result.next()) {
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
        closeConnection(connection);
        return tickets;
    }

    // Get Users list from database

    public ArrayList<User> getUserList() throws Exception {
        Connection connection = Connect.INSTANCE.getConnection();
        ResultSet result = getTableData("User", connection);
        ArrayList<User> users = new ArrayList<>();
        while (result.next()) {
            try {
                User user = new User();
                user.setBirthday(result.getDate("Date_Of_Birth"));
                user.setEmail(result.getString("Email"));
                user.setName(result.getString("Name"));
                user.setPassword("Password");
                user.setSurname(result.getString("Surname"));
                user.setUserId(result.getInt("UserId"));
                users.add(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        closeConnection(connection);
        return users;
    }

    // Get Seats list from database

    public ArrayList<Seat> getSeatList() throws Exception {
        Connection connection = Connect.INSTANCE.getConnection();
        ResultSet result = getTableData("Seat", connection);
        ArrayList<Seat> seats = new ArrayList<>();
        while (result.next()) {
            try {
                Seat seat = new Seat();
                seat.setHallId(result.getInt("Hall"));
                seat.setPlace(result.getInt("Place"));
                seat.setRow(result.getInt("Row"));
                seat.setSeatId(result.getInt("SeatId"));
                seats.add(seat);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        closeConnection(connection);
        return seats;
    }

    // Get Movie Screening list from database

    public ArrayList<MovieScreening> getScreeningList() throws Exception {
        Connection connection = Connect.INSTANCE.getConnection();
        ResultSet result = getTableData("MovieScreening", connection);
        ArrayList<MovieScreening> moviesScreening = new ArrayList<>();
        while (result.next()) {
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
        closeConnection(connection);
        return moviesScreening;
    }

    // Get Movies list from database

    public ArrayList<Movie> getMovieList() throws Exception {
        Connection connection = Connect.INSTANCE.getConnection();
        ResultSet result = getTableData("Movie", connection);
        ArrayList<Movie> movies = new ArrayList<>();
        while (result.next()) {
            try {
                Movie movie = new Movie();
                movie.setDirector(result.getString("Director"));
                movie.setMovieId(result.getInt("MovieId"));
                movie.setName(result.getString("Name"));
                movies.add(movie);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        closeConnection(connection);
        return movies;
    }

    // Get Halls list from database

    public ArrayList<Hall> getHallList() throws Exception {
        Connection connection = Connect.INSTANCE.getConnection();
        ResultSet result = getTableData("Hall", connection);
        ArrayList<Hall> halls = new ArrayList<>();
        while (result.next()) {
            try {
                Hall hall = new Hall();
                hall.setCinemaId(result.getInt("Cinema"));
                hall.setHallId(result.getInt("HallId"));
                hall.setName(result.getString("Name"));
                halls.add(hall);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        closeConnection(connection);
        return halls;
    }

    // Get Cinemas list from database

    public ArrayList<Cinema> getCinemaList() throws Exception {
        Connection connection = Connect.INSTANCE.getConnection();
        ResultSet result = getTableData("Cinema", connection);
        ArrayList<Cinema> cinemas = new ArrayList<>();
        while (result.next()) {
            try {
                Cinema cinema = new Cinema();
                cinema.setAdress(result.getString("address"));
                cinema.setId(result.getInt("id"));
                cinema.setLatitude(result.getInt("latitude"));
                cinema.setName(result.getString("name"));
                cinemas.add(cinema);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        closeConnection(connection);
        return cinemas;
    }
}
