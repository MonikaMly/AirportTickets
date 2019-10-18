import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private static List<Ticket> tickets = new ArrayList<Ticket>();

    static {
        tickets.add(new Ticket(1,9, "Monika"));
    }
    public List<Ticket> getTickets(){
        return tickets;
    }
    public void createTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
