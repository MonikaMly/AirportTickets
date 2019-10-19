<%@ page import="Project.Model.Ticket" %>
<%@ page import="Project.DAO.TicketDAO" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets</title>
</head>
<body>
<table>
    <tr>
        <th>Ticket Id</th>
        <th>Flight Id</th>
        <th>User Login</th>
    </tr>

        <% for (Ticket ticket : TicketDAO.getTickets()){ %>
    <tr>
        <td><%=ticket.getId()%></td>
        <td><%=ticket.getFlightId()%></td>
        <td><%=ticket.getUserLogin()%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
