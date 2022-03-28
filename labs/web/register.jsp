<%-- 
    Document   : register
    Created on : 21/03/2022, 4:37:06 PM
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
        <h1>Hello World!</h1>
        
        
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
                <tr>
                    <td><label for="gender">Gender:</label><br></td>
                    <td><input type="text" id="gender" name="gender"><br></td>
                </tr>
                <tr>
                    <td><label for="dob">Date of Birth:</label><br></td>
                    <td><input type="date" id="dob" name="dob" required><br></td>
                </tr>
                <tr>
                    <td><label for="name">Favourite colour:</label><br></td>
                    <td><input type="text" id="favcol" name="favcol" required><br></td>
                </tr>
                <tr>
                    <td><label for="name">Agree to TOS:</label><br></td>
                    <td><input type="text" id="tos" name="tos"><br></td>
                </tr>
            </table>
            <div>
                <a href=""index.jsp">Cancel</a> 
                <input type="submit" formmethod="post" value="Register"><br>
            </div>
            

       </form> 
        
            
    </body>
</html>
