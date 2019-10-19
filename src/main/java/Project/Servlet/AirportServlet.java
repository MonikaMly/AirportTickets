package Project.Servlet;

import Project.DAO.AirportDAO;
import Project.Model.Airport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/airport")
public class AirportServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String type = req.getParameter("type");

        if(type.equals("add")) {
            Airport airport = new Airport(code, city, country);
            AirportDAO.addAirport(airport);
            resp.sendRedirect("airportlist.jsp");
        } else if(type.equals("update")){
            Airport airport = new Airport(code, city,country);
            AirportDAO.updateAirport(airport);
            resp.sendRedirect("airportlist.jsp");
        } else {
            resp.sendRedirect("airportlist.jsp");
        }
    }
}
