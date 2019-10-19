package Project.DAO;

import Project.Model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private static List<Ticket> tickets = new ArrayList<Ticket>();

    static {
        tickets.add(new Ticket(1,9, "Monika"));
    }
    public static List<Ticket> getTickets(){
        return tickets;
    }
    public static void createTicket(Ticket ticket){
        tickets.add(ticket);
    }
    public static Ticket getTicketById (int id){

        for (Ticket ticket : tickets) {
            if (ticket.getId() == id){
                return ticket;
            }
        }
        return null;
    }

    public static void updateTicket(Ticket ticket){
        TicketDAO.getTicketById(ticket.getId()).setFlightId(ticket.getFlightId());
        TicketDAO.getTicketById(ticket.getId()).setUserLogin(ticket.getUserLogin());
    }
}
