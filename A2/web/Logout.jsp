<%-- 
    Document   : Logout
    Created on : May 14, 2022, 3:58:18 AM
    Author     : jaehyeon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp">back home</a>
        <%
        session.invalidate();
        %>
    </body>
</html>
