<%@ page import="Project.Model.Flight" %>
<%@ page import="Project.DAO.FlightDAO" %>
<%@ page import="Project.Model.Airport" %>
<%@ page import="Project.DAO.AirportDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 20.10.2019
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Flight</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Flight flight = FlightDAO.getFlightById(Integer.parseInt(id));
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
%>

<h1>Update TICKET <b><%=flight.getId()%></b></h1>

<form action="flight" method="post">
    <input type="hidden" name="type" value="update">
    <input name="id" value="<%=flight.getId()%>">
    Departure Date:
    <input type="date" name="departuredate" required value="<%=dateFormatter.format(flight.getDepartureDate())%>">
    Arrival Date:
    <input type="date" name="arrivaldate" required value="<%=dateFormatter.format(flight.getDepartureDate())%>">

    <%List<Airport> airports = AirportDAO.getAirports(); %>

    From:
    <select name="airportfrom">
        <%
            for (Airport airport : airports) {
        %>
        <option value="<%=airport.getCode()%>"><%=airport.getCode()%></option>
        <%   } %>
    </select>
    To:
    <select name="airportto">
        <%
            for (Airport airport : airports) {
        %>
        <option value="<%=airport.getCode()%>"><%=airport.getCode()%></option>
        <%   } %>
    </select>
    Price:
    <input type="number" placeholder="Enter price" name="price" required value="<%=flight.getPrice()%>">
    Total seats:
    <input type="number" placeholder="Enter seats" name="seats" required value="<%=flight.getTotalSeats()%>">
    <input type="submit" value="Update">
</form>
</body>
</html>
