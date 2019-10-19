<%@ page import="Project.Model.Ticket" %>
<%@ page import="Project.DAO.TicketDAO" %>
<%@ page import="Project.Model.Flight" %>
<%@ page import="Project.DAO.FlightDAO" %>
<%@ page import="Project.Model.User" %>
<%@ page import="Project.DAO.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Ticket</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Ticket ticket = TicketDAO.getTicketById(id);
%>
<h1>Update TICKET <b><%=ticket.getId()%></b></h1>

<form action="ticket" method="post">
    <input type="hidden" name="type" value="update">
    <input name="id" value="<%=ticket.getId()%>">
    Flight:
    <select name="flightId">
        <%
            for (Flight flight : FlightDAO.getFlights()) {
        %>
        <option value="<%=flight.getId()%>"><%=flight.getId()%></option>
        <%   } %>
    </select>
    User:
    <select name="userLogin">
        <%
            for (User user : UserDAO.getAllUsers()) {
        %>
        <option value="<%=user.getLogin()%>"><%=user.getLogin()%></option>
        <%   } %>
    </select>
    <input type="submit" value="Update">
</form>
</body>
</html>
