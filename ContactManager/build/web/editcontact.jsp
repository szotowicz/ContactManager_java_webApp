<%-- 
    Document   : editcontact
    Created on : 2017-03-08, 15:06:34
    Author     : Mikołaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CONTACT MANAGER</h1>
        <form action="./ContactController" method="POST">
            <input type="hidden" name="idContact" value="${contact.idContact}">
            Name: <input type="text" name="name" value="${contact.name}"><br />
            Last name: <input type="text" name="lastName" value="${contact.lastName}"><br />
            Email: <input type="text" name="email" value="${contact.email}"><br />
            Category: <input type="text" name="category" value="${contact.category}"><br />
            Subcategory: <input type="text" name="subcategory" value="${contact.subcategory}"><br />
            Phone number <input type="text" name="phoneNumber" value="${contact.phoneNumber}"><br />
            Birthdate (YYYY-MM-DD): <input type="text" name="birthDate" value="${contact.birthDate}"><br />
            
            <input type="submit" name="operation" value="Add" />
            <input type="submit" name="operation" value="Edit" />
            <input type="submit" name="operation" value="Delete" />
            
            <br /><br /><br />
            <a href="./ViewContactListController"> Cancel </a><br />
        </form>
    </body>
</html>
