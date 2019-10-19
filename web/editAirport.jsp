<%@ page import="Project.Model.Airport" %>
<%@ page import="Project.DAO.AirportDAO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Airport</title>
</head>
<body id="page-top">

        <%
            String code = request.getParameter("code");
            Airport airport = AirportDAO.getAirportByCode(code);
        %>
        <h1>Update airport <b><%=airport.getCode()%></b></h1>

        <form action="airport" method="post">
            <input type="hidden" name="type" value="update">
            <input name="code" value="<%=airport.getCode()%>">
                City:
                <input type="text" placeholder="Enter airport city" name="city" required value="<%=airport.getCity()%>">
                Country:
                <input type="text" placeholder="Enter country" name="country" required value="<%=airport.getCountry()%>">
            <input type="submit" value="Update">
        </form>
</body>

</html>
