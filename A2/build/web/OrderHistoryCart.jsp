<%-- Jaehyeon Peang (13742972) --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
        <c:forEach items="${cartDetail}" var="product"> 
            <tr>     
            <td>${product.productName}</td>
            <td>${product.price * product.quantity}</td>
            <td>${product.quantity}</td>
        </tr>
            </c:forEach>
        </table>
        
        <a href="Logout.jsp">logout</a>
    </body>
</html>
