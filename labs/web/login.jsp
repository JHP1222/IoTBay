<%-- 
    Document   : login
    Created on : 28/03/2022, 1:57:12 PM
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
        <form action="/labs/welcome.jsp" method="post">
            <table>
                <tr>
                    <td><label for="email">Email</label><br></td>
                    <td><input type="email" id="email" name="email" required><br></td>
                </tr>
                <tr>
                    <td><label for="name">Name:</label><br></td>
                    <td><input type="text" id="name" name="name" required><br></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label><br></td>
                    <td><input type="password" id="password" name="password" required><br></td>
                </tr>
               
            </table>
            <div>
                <a href=""index.jsp">Cancel</a> 
                <input type="submit" formmethod="post" value="Login"><br>
            </div>
    </body>
</html>
