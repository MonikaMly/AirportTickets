<%@ page import="Project.Model.Airport" %>
<%@ page import="Project.DAO.AirportDAO" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Airports</title>
</head>
<body>
<table>
    <tr>
        <th>Code</th>
        <th>City</th>
        <th>Country</th>
    </tr>

        <% for(Airport airport : AirportDAO.getAirports()) {%>
    <tr>
        <td><%=airport.getCode()%></td>
        <td><%=airport.getCity()%></td>
        <td><%=airport.getCountry()%></td>
        <td> <a href="editAirport.jsp?code=<%=airport.getCode()%>">Edit</a></td>
    </tr>

    <% } %>
</table>
</body>
</html>
