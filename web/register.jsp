<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post" action="register">
    Login:
    <input name="login" type="text">
    <br/>
    Password:
    <input name="password" type="password">
    <br/>
    Name:
    <input name="name" type="text">
    <br/>
    Surname:
    <input name="surname" type="text">
    <br/>
    City:
    <input name="city" type="text">
    <br/>
    Birth Year:
    <input name="birthYear" type="number">
    <br/>
    <input type="submit" value="Register"/>
</form>

<form method="get" action="login.jsp">
    Already registered?
    <br/>
    <input type="submit" value="Login">
</form>
</body>
</html>
