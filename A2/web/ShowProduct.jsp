<%-- 
    Document   : showProduct
    Created on : May 15, 2022, 11:28:42 PM
    Author     : jaehyeon
--%>

<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="navbar.jsp"%>
        <h1 class="display-1 text-center ]"> Currently Selected</h1>
        <h2>Current Order ID: ${currentOrderID}</h2>
        <table>
            <tr>
                <td> ${orderedProduct.productName}</td>
            </tr>
            <tr>
                <td> ${orderedProduct.productType}</td>
            </tr>
            <tr>
                <td> ${orderedProduct.productPrice}</td>
            </tr>
        </table>
        
        <form method="post" action="AddToCartServlet">
           <table>
               <tr>
                <td><input class="button" type="submit" value="Add Item"></td>
               </tr>
           </table>
       </form>
       

        <tr>
            <td><a href= "AllProducts.jsp"> Back</a></td>
        </tr>

    </body>
</html>
