import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private static List<Ticket> tickets = new ArrayList<Ticket>();

    static {
        tickets.add(new Ticket(1,123, "login1"));
    }
    public List<Ticket> getTickets(){
        return tickets;
    }
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
