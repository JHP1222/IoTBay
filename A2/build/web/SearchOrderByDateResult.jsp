<%-- 
    Document   : SearchOrderByDateResult
    Created on : May 19, 2022, 7:18:57 PM
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
        <table>
            <tr>
            <th>Order ID</th>
            <th>Total Price</th>
            <th>Order Date</th>
            </tr>
        <c:forEach items="${SearchOrderByDateResultOrder}" var="order">  
        <tr>
            
            <td>${order.orderID}</td>
            <td>$${order.totalPrice}</td>
            <td>${order.orderDate}</td>
                
        
        </tr>
         </c:forEach>
        </table>
    </body>
</html>
