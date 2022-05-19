<%-- 
    Document   : OrderConfirmation
    Created on : May 18, 2022, 3:44:58 AM
    Author     : jaehyeon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Confirmation Page</title>
    </head>
    <body>
        <h1>Order Summary</h1>
        <table>
            <tr>
                <td> Order ID: ${currentOrderID}</td>
            </tr>
            <tr>
                <td> Order Date: ${date}</td>
            </tr>
            <tr>
                <td> Total Price: ${totalPrice}</td>
            </tr>  
        </table>
            <a href="Welcome.jsp">Proceed To Payment </a>
            
    </body>
</html>
