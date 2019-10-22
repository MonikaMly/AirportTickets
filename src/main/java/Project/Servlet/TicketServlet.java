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
        String id = req.getParameter("id");
        int newId = (int) (Math.random() * 1000000);
        String flightId = req.getParameter("flightId");
        int flightIdToAdd = Integer.parseInt(flightId);
        String userLogin = req.getParameter("userLogin");
        String type = req.getParameter("type");

        if(type.equals("add")) {
            Ticket ticket = new Ticket(newId, flightIdToAdd, userLogin);
            TicketDAO.createTicket(ticket);
            resp.sendRedirect("ticketlist.jsp");
        }
    }
}
