<%-- 
    Author     : jaehyeon
--%>

<%@page import="uts.isd.model.Order"%>
<%@page import="uts.isd.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Product product= (Product) session.getAttribute("orderedProduct");
            //int currentOrderID = (Integer)session.getAttribute("currentOrderID");
        %>
        <h1>Hello World!</h1>
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
            <tr>
                <td> ${currentProductName}</td>
            </tr>
             <tr>
                <td> ${currentProductPrice}</td>
            </tr>
            
        </table>

    </body>
</html>
