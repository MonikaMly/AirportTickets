<%@ page import="Project.DAO.FlightDAO" %>
<%@ page import="Project.Model.Flight" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Departure date</th>
        <th>Arrival date</th>
        <th>From</th>
        <th>To</th>
        <th>Price</th>
        <th>Seats</th>
    </tr>
    <%
        for (Flight flight : FlightDAO.getFlights()) { %>

    <tr>
        <td><%=flight.getId()%></td>
        <td><%=flight.getDepartureDate()%></td>
        <td><%=flight.getArrivalDate()%></td>
        <td><%=flight.getAirportFromCode()%></td>
        <td><%=flight.getAirportToCode()%></td>
        <td><%=flight.getPrice()%></td>
        <td><%=flight.getTotalSeats()%></td>
    </tr>



    <%    } %>



</table>
</body>
</html>
