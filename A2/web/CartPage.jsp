<%-- Jaehyeon Peang - 13742972--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Cart"%>
<%@page import="java.text.DecimalFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <link rel= "stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="navbar.jsp"%>
        <div class="container">
            <div class="d-flex py-3">
                  <%
                    ArrayList<Cart> currentCart = (ArrayList<Cart>) session.getAttribute("currentCart");
                    double totalPrice = 0;  

                  %>
               
                <a href="OrderConfirmationServlet" class="mx-3 btn btn-success"> Confirm Order</a>        
                <a  href="CancelOrderServlet"class="mx-3 btn btn-danger"> Cancel Order</a>  
            </div>
            <table class="table table-light">
                <tr>
                    <th> Product Name</th>
                    <th> Unit Price</th>
                    <th> Quantity</th>
                    <th> Remove</th>
                </tr>
                <tr>
                    <% 
                    if (currentCart != null) { 
                            for (Cart c : currentCart) {
                                totalPrice = totalPrice + (c.getPrice() * c.getQuantity());
                     %>
                   
                    <td><%= c.getProductName()%></td>
                    <td>$ <%=c.getPrice() * c.getQuantity()%></td>
                    <td>
                        <form action="" class="form-inline">
                            <input type="hidden" name="id" value="1" class="form-input"> 
                            <div class="form-group d-flex justify-content-between">
                                <a class="btn btn-sm btn-decre" href="ChangeQuantityServlet?action=dec&productID=<%= c.getProductID()%>"> <i class="fas fa-minus-square"></i></a>
                                <input type="text" name="quantity" class="form-control" value="<%= c.getQuantity()%>" readonly>
                                <a class="btn btn-sm btn-incre" href="ChangeQuantityServlet?action=inc&productID=<%= c.getProductID()%>"> <i class="fas fa-plus-square"></i></a>

                            </div>
                        </form>
                    </td>
                    <td> <a class="btn btn-sm btn-danger" href="RemoveItemServlet?productID=<%= c.getProductID()%> ">Remove Item</a></td>
                </tr>               

                <%}
                    }
                session.setAttribute("totalPrice", totalPrice);%>
                  <h4> Total Price: $ <%=totalPrice%></h4> 
                <a class="display-6 mt-5 text-decoration-none" href="AllProducts.jsp">Back</a>
            </table>
        </div>
                
    </body>
</html>
