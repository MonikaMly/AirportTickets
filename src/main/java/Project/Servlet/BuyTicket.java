package Project.Servlet;


import Project.DAO.TicketDAO;
import Project.Model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buyTicket")
public class BuyTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flightId = req.getParameter("flightId");
        int flightIdNumber = Integer.parseInt(flightId);
        String login = (String) req.getSession().getAttribute("login");

        Ticket ticket = new Ticket(0, flightIdNumber, login);
        TicketDAO.createTicket(ticket);


        resp.sendRedirect(resp.encodeRedirectURL("ticketlist.jsp"));
    }
}
