<%-- 
    Document   : signin
    Created on : 2017-03-07, 21:05:37
    Author     : Mikołaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
    </head>
    <body>
        <h1>CONTACT MANAGER</h1>
        <form action="./SignInController" method="POST">
            
            email: <input type="text" name="email"><br />
            password: <input type="password" name="password"><br />
            <input type="submit" value="SIGN IN" />
            
            <br /><br /><br />
            <a href="./AllUsersController"> Cancel </a><br />
        </form>
    </body>
</html>
