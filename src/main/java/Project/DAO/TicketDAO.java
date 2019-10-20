package Project.DAO;

import Project.Config.DBConnection;
import Project.Model.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TicketDAO {

    public static int getTickets(int flightId){
        try {
            PreparedStatement ps = DBConnection.createConnection()
                    .prepareStatement("SELECT count(*) as ticketsNumber FROM airport.ticket WHERE flightid = ?");
            ps.setInt(1, flightId);

            ResultSet rs = ps.executeQuery();

            rs.next();
            return rs.getInt("ticketsNumber");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void createTicket(Ticket ticket){
        try {
            PreparedStatement ps = DBConnection.createConnection()
                    .prepareStatement("INSERT INTO ticket VALUES (null, ?, ?);");
            ps.setInt(1, ticket.getFlightId());
            ps.setString(2, ticket.getUserLogin());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static boolean hasUserTicketForFlight(String login, int flightId) {
        try {
            PreparedStatement ps = DBConnection.createConnection()
                    .prepareStatement("SELECT * FROM airport.ticket WHERE user = ? AND flightid = ?;");
            ps.setString(1, login);
            ps.setInt(2, flightId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
