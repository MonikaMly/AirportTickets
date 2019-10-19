<%@ page import="Project.Model.Flight" %>
<%@ page import="Project.DAO.FlightDAO" %>
<%@ page import="Project.Model.Airport" %>
<%@ page import="Project.DAO.AirportDAO" %><%--
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
    int id = Integer.parseInt(request.getParameter("id"));
    Flight flight = FlightDAO.getFlightById(id);
%>

<h1>Update TICKET <b><%=flight.getId()%></b></h1>

<form action="flight" method="post">
    <input type="hidden" name="type" value="update">
    <input name="id" value="<%=flight.getId()%>">
    Departure Date:
    <input type="date" placeholder="Enter departurw Date" name="departureDate" required value="<%=flight.getDepartureDate()%>">
    Arrival Date:
    <input type="dare" placeholder="Enter departurw Date" name="departureDate" required value="<%=flight.getDepartureDate()%>">
    From:
    <select name="from">
        <%
            for (Airport airport : AirportDAO.getAirports()) {
        %>
        <option value="<%=airport.getCode()%>"><%=airport.getCode()%></option>
        <%   } %>
    </select>
    To:
    <select name="to">
        <%
            for (Airport airport : AirportDAO.getAirports()) {
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
