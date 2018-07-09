<%-- 
    Document   : contactlist
    Created on : 2017-03-05, 20:38:56
    Author     : Mikołaj
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact list</title>
    </head>
    <body>
        
        <h1>Contact list of ${requestScope.owner}: </h1>

        <table border="1">
            <th> </th>
            <th>Name</th>
            <th>Last name</th>
            <th>Email address</th>
                <c:forEach items="${requestScope.contactList}" var="contact">
                <tr>
                    <td><a href="./GetContactController?id=${contact.idContact}"> see more </td>
                    <td>${contact.name}</td>
                    <td>${contact.lastName}</td>
                    <td>${contact.email}</td>
                </tr>
            </c:forEach>

        </table
        <br /><br />
        <a href="editcontact.jsp"> Add new </a><br />

        <br /><br />
        <a href="./AllUsersController"> Sign out </a><br />
            
    </body>
</html>
