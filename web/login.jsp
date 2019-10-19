<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 19.10.2019
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="login">
    Login:
    <input name="login" type="text">
    <br/>
    Password:
    <input name="password" type="password">
    <br/>
    <input type="submit" value="Login"/>
</form>

<form method="get" action="register.jsp">
    Don't have a login?
    <br/>
    <input type="submit" value="Register">
</form>

</body>
</html>
