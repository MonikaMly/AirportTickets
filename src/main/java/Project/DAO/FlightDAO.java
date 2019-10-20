package Project.DAO;

import Project.Config.DBConnection;
import Project.Model.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDAO {

    public static List<Flight> getFlights(){
        List<Flight> flights = new ArrayList<>();
        Connection connection = DBConnection.createConnection();

        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM airport.flight;");
            while (rs.next()){
                int id = rs.getInt("id");
                java.util.Date departureDate = rs.getDate("departureDate");
                java.util.Date arrivalDate = rs.getDate("arrivalDate");
                String from = rs.getString("from");
                String to = rs.getString("to");
                double price = rs.getDouble("price");
                int seats = rs.getInt("seats");

                Date departure = new Date(departureDate.getTime());
                Date arrival = new Date(arrivalDate.getTime());

                Flight flight = new Flight(id,departure,arrival,from,to,price,seats);
                flights.add(flight);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public static void addFlight(Flight flight){
        try {
            PreparedStatement ps = DBConnection.createConnection().prepareStatement("INSERT INTO flight VALUES (null, ?, ?, ?, ?, ?, ?);");

            ps.setDate(1, new java.sql.Date(flight.getDepartureDate().getTime()));
            ps.setDate(2, new java.sql.Date(flight.getArrivalDate().getTime()));
            ps.setString(3, flight.getAirportFromCode());
            ps.setString(4, flight.getAirportToCode());
            ps.setDouble(5, flight.getPrice());
            ps.setInt(6, flight.getTotalSeats());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Flight getFlightById(int id){
        try {
            PreparedStatement ps = DBConnection.createConnection().prepareStatement("SELECT * FROM flight WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                java.sql.Date departureDate = rs.getDate("departureDate");
                java.sql.Date arrivalDate = rs.getDate("arrivalDate");
                String airportFromCode = rs.getString("from");
                String airportToCode = rs.getString("to");
                double price = rs.getDouble("price");
                int totalSeats = rs.getInt("seats");

                Date departureDateUtil = new Date(departureDate.getTime());
                Date arrivalDateUtil = new Date(arrivalDate.getTime());

                return new Flight(id, departureDateUtil, arrivalDateUtil, airportFromCode, airportToCode, price, totalSeats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void removeById (int id){
        Connection connection = DBConnection.createConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM airport.flight where id = ?;");

            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFlight (Flight flight){
        Connection connection = DBConnection.createConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE flight SET airport.flight.departuredate = ?, airport.flight.arrivaldate = ?, airportfrom = ?, airportto = ?, airport.flight.price = ?, seats = ? WHERE id = ?;");

            java.sql.Date departure = new java.sql.Date(flight.getDepartureDate().getTime());
            java.sql.Date arrival = new java.sql.Date(flight.getArrivalDate().getTime());

            ps.setDate(1, departure);
            ps.setDate(2, arrival);
            ps.setString(3, flight.getAirportFromCode());
            ps.setString(4, flight.getAirportToCode());
            ps.setDouble(5, flight.getPrice());
            ps.setInt(6, flight.getTotalSeats());
            ps.setInt(7, flight.getId());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
