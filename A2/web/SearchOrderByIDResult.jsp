<%-- 
    Document   : SearchOrderByIDResult
    Created on : May 19, 2022, 2:54:51 AM
    Author     : jaehyeon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order ID: ${SearchOrderByIDResultOrder.orderID} </h1>
            
        <h2> Total Price: $${SearchOrderByIDResultOrder.totalPrice} </h2>
           
        <table>
            <tr>
                <th>ProductName: </th>
                <th>Total Quantities:</th>
                <th>Product Total Price: </th>
               
            </tr>
            
            <c:forEach items="${SearchOrderByIDResultCart}" var="order">  
                <tr>
                    <td> ${order.productName}</td>               
                    <td> ${order.quantity}</td>
                    <td> $${order.price * order.quantity}  </td>
                      
                </tr>
            </c:forEach>
                
        </table>
        <a href="ViewOrderHistory.jsp"> BACK</a>
    </body>
</html>
