<%-- 
    Document   : orderHistory
    Created on : May 12, 2022, 9:49:27 PM
    Author     : jaehyeon
--%>

<%@page import="uts.isd.model.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Order"%>
<%@page import="uts.isd.model.Cart"%>
<%@page import="uts.isd.model.dao.DBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="Order.css">
        <title>My Order History</title>
    </head>
    
    <%
        Customer customer = (Customer) session.getAttribute("currentCustomer");
        int currentCustomerID = customer.getCustomerId();
    %>
    
    
<body>
     <% if (currentCustomerID != 0) { %>
        <h1 class="text-center"> View Order History</h1>
        <form action="SearchOrderByIDServlet">
        <h5 class="text-center">Search Order By ID: 
            <input class="text-center" type="number" name="orderID"> 
            <input class="text-center" type="submit" value="Search">
        </h5>
        </form>
 
        <form action="SearchOrderByDateServlet">
        <h5 class="text-center">Search Order By Date:
            <input type="date"  name="orderDate">
            <input class="text-center" type="submit" value="Search">
        </h5>
        </form>
        <table class="table table-responsive >
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Total Price</th>
                </tr>

        <table>
            <c:forEach items="${orders}" var="order">  
  
            <tr>
            <td>${order.orderID}</td>
            <td>${order.orderDate}</td>
            <td>$ ${order.totalPrice}</td>
            <td>
               <td><a href="OrderCartHistoryServlet?orderID=${order.orderID}"> view Details</a></td>
            </td>
            </tr>
            
           
            

            </c:forEach>
        </table>
 
    <% } else { %>
    <h2>Order List</h2>
    <p>Not logged In. Please log in to view previous orders</p>
    <% }%>
    <a href="Welcome.jsp">Back</a>
</body>         
</html>
