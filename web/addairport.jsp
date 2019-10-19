<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Airport</title>
</head>
<body>
<form method="post" action="airport">
    <input type="hidden" name="type" value="add">
    Code:
    <input name="code" type="text">
    <br/>
    City:
    <input name="city" type="password">
    <br/>
    Country:
    <input name="country" type="text">
    <br/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
