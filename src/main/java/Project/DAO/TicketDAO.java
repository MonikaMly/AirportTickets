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
}
