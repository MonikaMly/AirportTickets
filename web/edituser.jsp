<%@ page import="Project.DAO.UserDAO" %>
<%@ page import="Project.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 20.10.2019
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>

</head>
<body>
<%
    String login = request.getParameter("login");
    User user = UserDAO.getUserByLogin(login);
%>
<h1>Update user <b><%=user.getLogin()%></b></h1>

<form action="register" method="post">
    <input type="hidden" name="type" value="update">
    <input name="login" value="<%=user.getLogin()%>">
</br>
    Password:
    <input type="password" placeholder="Enter password" name="password" required value="<%=user.getPassword()%>">
    </br>
    Name:
    <input type="text" placeholder="Enter name" name="name" required value="<%=user.getName()%>">
    </br>
    Surname:
    <input type="text" placeholder="Enter surname" name="surname" required value="<%=user.getSurname()%>">
    </br>
    City:
    <input type="text" placeholder="Enter city" name="city" required value="<%=user.getCity()%>">
    </br>
    Birth Year:
    <input type="number" placeholder="Enter year" name="birthYear" required value="<%=user.getBirthYear()%>">
    </br>
    <input type="submit" value="Update">
</form>
</body>
</html>
