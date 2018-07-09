<%-- 
    Document   : adduser
    Created on : 2017-03-07, 19:59:35
    Author     : Mikołaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add user</title>
    </head>
    <body>
        <h1>NEW ACCOUNT</h1>
        <form action="./AddUserController" method="POST">
            
            email: <input type="text" name="email"><br />
            name: <input type="text" name="name"><br />
            last name: <input type="text" name="lastName"><br />
            password: <input type="text" name="password"><br />
            <input type="submit" value="SIGN UP" />
            
            <br /><br /><br />
            <a href="./AllUsersController"> Cancel </a><br />
        </form>
    </body>
</html>
