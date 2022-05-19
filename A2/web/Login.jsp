<%-- 
    Document   : Login
    Created on : May 14, 2022, 3:47:12 AM
    Author     : jaehyeon
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    
    <%
         Customer customer = (Customer)session.getAttribute("currentCustomer");
         customer.setCustomerId(1);
         session.setAttribute("currentCustomerID", 1);
    %>
    <body>
        <h1>Hello World!</h1>
        <form action="Welcome.jsp">
            <table>
                <tr>
                    <td>Customer ID: ${currentCustomerID}</td>
                    <td><input name="customerID" type="text"></td>
                    <td><input type="submit" ></td>
                </tr>
            </table>         
        </form>
        
        <a href="CurrentOrderServlet">go to welcome</a>
    </body>
</html>
