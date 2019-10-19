<%@ page import="Project.DAO.FlightDAO" %>
<%@ page import="Project.Model.Flight" %>
<%@ page import="Project.Model.User" %>
<%@ page import="Project.DAO.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Ticket</title>
</head>
<body>
<form method="post" action="ticket">
    Id:
    <input name="Id" type="number">
    <br/>
    Flight Id:
    <select name="flightId">
    <%
        for (Flight flight : FlightDAO.getFlights()) {
    %>
        <option value="<%=flight.getId()%>"><%=flight.getId()%></option>
        <%   } %>
    </select>
    <br/>
    User:
    <select name="userLogin">
        <%
            for (User user : UserDAO.getAllUsers()) {
        %>
        <option value="<%=user.getLogin()%>"><%=user.getLogin()%></option>
        <%   } %>
    </select>
    <br/>
    <input type="submit" value="Add Ticket"/>
    <br/>
</form>
</body>
</html>
