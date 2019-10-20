package Project.DAO;

import Project.Config.DBConnection;
import Project.Model.Airport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO {

    public static List<Airport> getAirports() {
        Connection connection = DBConnection.createConnection();

        List<Airport> airports = new ArrayList<>();

        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM airport.airport;");

            while (rs.next()) {
                String code = rs.getString("code");
                String city = rs.getString("city");
                String country = rs.getString("country");

                airports.add(new Airport(code, city, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }

    public static void addAirport(Airport airport) {
        Connection connection = DBConnection.createConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO airport.airport VALUES (?, ?, ?);");

            ps.setString(1, airport.getCode());
            ps.setString(2, airport.getCity());
            ps.setString(3, airport.getCountry());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static Airport getAirportByCode(String code) {
        Connection connection = DBConnection.createConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM airport.airport WHERE code = ?;");

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String city = rs.getString("city");
                String country = rs.getString("country");

                return new Airport(code, city, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteByCode(String code) {
        Connection connection = DBConnection.createConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM airport.airport WHERE code = ?;");
            ps.setString(1, code);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void updateAirport(Airport airport) {
        Connection connection = DBConnection.createConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE airport.airport SET city = ?, country = ? WHERE code = ?;");
            ps.setString(1, airport.getCity());
            ps.setString(2, airport.getCountry());
            ps.setString(3, airport.getCode());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
