<%@ page import="java.util.List" %>
<%@ page import="Project.DAO.UserDAO" %>
<%@ page import="Project.Model.User" %>
<%@ page import="Project.Service.UserService" %><%--
  Created by IntelliJ IDEA.
  Project.Model.User: Huawei
  Date: 19.10.2019
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>

    <link rel="stylesheet"  href="CSS/styles.css" type="text/css" >
</head>
<body>
<table>
    <tr>
    <th>Login</th>
    <th>Name</th>
    <th>Surname</th>
    <th>City</th>
    <th>Birth Year</th>
    </tr>
    <%
        List<User> allUsers = UserDAO.getAllUsers();
        for (User user : allUsers) {

    %>

    <tr>
        <td><%=user.getLogin()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getSurname()%></td>
        <td><%=user.getCity()%></td>
        <td><%=user.getBirthYear()%></td>
        <td> <a href="edituser.jsp?login=<%=user.getLogin()%>">Edit</a></td>
        <td> <a href="register?login=<%=user.getLogin()%>&type=delete">Delete</a></td>
    </tr>
    <%}%>


</table>
</body>
</html>
