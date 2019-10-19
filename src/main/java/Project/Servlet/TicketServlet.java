package Project.Servlet;

import Project.DAO.TicketDAO;
import Project.Model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int flightId = Integer.parseInt(req.getParameter("flightId"));
        String userLogin = req.getParameter("userLogin");
        String type = req.getParameter("type");

        if(type.equals("add")) {
            Ticket ticket = new Ticket(id, flightId, userLogin);

            TicketDAO.createTicket(ticket);
        } else if (type.equals("update")){
            Ticket ticket = new Ticket(id, flightId, userLogin);
            TicketDAO.updateTicket(ticket);
        }
    }
}
