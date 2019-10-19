package Project.Servlet;

import Project.DAO.FlightDAO;
import Project.Model.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/flight")
public class FlightServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int idToAdd = Integer.parseInt(id);
        String departureDate = req.getParameter("departureDate");
        String arrivalDate = req.getParameter("arrivalDate");
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        double price = Double.parseDouble(req.getParameter("price"));
        int seats = Integer.parseInt(req.getParameter("seats"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        try {
            Date departure = simpleDateFormat.parse(departureDate);
            Date arrival = simpleDateFormat.parse(arrivalDate);

            Flight flight = new Flight(idToAdd,departure,arrival,from,to,price,seats);
            FlightDAO.addFlight(flight);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
