
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Log in to IoTBay</h1>
        <form action="/welcome.jsp" method="post">
            <table>
                <tr>
                    <td><label for="email">Email</label><br></td>
                    <td><input type="email" id="email" name="email" required><br></td>
                </tr>
                <tr>
                    <td><label for="name">Name</label><br></td>
                    <td><input type="name" id="name" name="name" required><br></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label><br></td>
                    <td><input type="password" id="password" name="password" required><br></td>
                </tr>
               
            </table>
            <div>
                <a href=""index.jsp">Cancel</a> 
                <input type="submit" formmethod="post" value="Login"><br>
                <a href=""main.jsp">Login as guest</a>
            </div>
    </body>
</html>
