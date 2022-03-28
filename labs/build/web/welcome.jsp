<%-- 
    Document   : welcome
    Created on : 21/03/2022, 4:56:30 PM
    Author     : chloe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String favcol = request.getParameter("favcol");
        %>
        <h1>Welcome <%= name %>!</h1>
        <h1>Your Email is <%= email %></h1>
        <h1>Your password is <%= password %></h1>
        <h1>Your gender is <%= gender %></h1>
        <h1>Your favourite colour is <%= favcol %></h1>
    </body>
</html>
