<%-- 
    Document   : allusers
    Created on : 2017-03-07, 17:09:52
    Author     : Mikołaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All users</title>
    </head>
    <body>
        <a href="signin.jsp"> Sign in </a><br />
        <a href="adduser.jsp"> Sign up </a>
        <h3> List of users: </h3>
        <table border="1">
            <th>User name</th>
            <th>User last name</th>
            <th>Email address</th>
            <c:forEach items="${requestScope.usersList}" var="contact">
                <tr>
                    <td>${contact.name}</td>
                    <td>${contact.lastName}</td>
                    <td>${contact.email}</td>
                </tr>
            </c:forEach>
          
        </table>
    </body>
</html>
