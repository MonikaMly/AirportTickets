<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Flight</title>
</head>
<body>
<form method="post" action="flight">
    <input type="hidden" name="type" value="add">
    Id:
    <input name="id" type="number">
    <br/>
    Departure Date:
    <input name="departureDate" type="date">
    <br/>
    Arrival Date:
    <input name="arrivalDate" type="date">
    <br/>
    From:
    <input name="from" type="text">
    <br/>
    To:
    <input name="to" type="text">
    <br/>
    Price:
    <input name="price" type="number">
    <br/>
    Total seats:
    <input name="seats" type="number">
    <br/>
    <input type="submit" value="Add Flight"/>
</form>
</body>
</html>
