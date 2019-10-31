<%@ page import="Project.Model.Ticket" %>
<%@ page import="Project.DAO.TicketDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="Project.Model.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="Project.Model.Airport" %>
<%@ page import="Project.DAO.FlightDAO" %>
<%@ page import="Project.DAO.AirportDAO" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 22.10.2019
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of tickets</title>
</head>
<body>
<table>
        <tr>
            <th>Departure date</th>
            <th>Arrival date</th>
            <th>From</th>
            <th>To</th>
            <th>Price</th>
            <th>Seats (total)</th>
            <th>Seats (free)</th>
            <th>Actions</th>
        </tr>

    <%

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        List<Flight> allFlights = FlightDAO.getFlights();
        for (Flight flight : allFlights) {


            Airport fromAirport = AirportDAO.getAirportByCode(flight.getAirportFromCode());
            Airport toAirport = AirportDAO.getAirportByCode(flight.getAirportToCode());

            int ticketsNumber = TicketDAO.getTicketsForFlight(flight.getId());

            int freeSeats = flight.getTotalSeats() - ticketsNumber;
    %>
    <tr>
        <td><%=date.format(flight.getDepartureDate())%></td>
        <td><%=date.format(flight.getArrivalDate())%></td>
        <td><%=flight.getAirportFromCode()%> (<%=fromAirport.getCity()%>/<%=fromAirport.getCountry()%>)</td>
        <td><%=flight.getAirportToCode()%> (<%=toAirport.getCity()%>/<%=toAirport.getCountry()%>)</td>
        <td><%=flight.getPrice()%> PLN</td>
        <td><%=flight.getTotalSeats()%></td>
        <td><%=freeSeats%></td>

            <%
                    String login = (String) session.getAttribute("login");
                    boolean hasUserTicketForFlight = TicketDAO.hasUserTicketForFlight(login, flight.getId());

                    if(!hasUserTicketForFlight) {
                %>

        <td>
            <a href="buyTicket?flightId=<%=flight.getId()%>">BUY TICKET</a>
        </td>
        <%
        } else {
        %>
        <td>
            <div>
                You have ticket for this flight!
            </div>
        </td>
        <%
            }
        %>
    </tr>
<%
        } %>
</table>
</body>
</html>