<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.assignment1.model.User"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
        %>
        <h1>Welcome to IoTBay <%= name %>!</h1>
        <p>We hope you enjoy your browsing experience</p>
        <p>Click <a href = "main.jsp" >here </a>to proceed to main page</p>
        
        <%
            User user = new User (name,email,password,dob);
            session.setAttribute("user", user);
        %>
    </body>
</html>
