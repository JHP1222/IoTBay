<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String favcol = request.getParameter("favcol");
        %>
        <h1>Welcome <%= name %>!</h1>
        <h1>Your Email is <%= email %></h1>
        <h1>Your gender is <%= gender %></h1>
        <h1>Your favourite colour is <%= favcol %></h1>
        Click <a href = "main.jsp" >here </a>to proceed to main page
    </body>
</html>