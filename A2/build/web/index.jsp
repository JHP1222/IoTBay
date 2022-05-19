<!--Benjamin Cornwell 13919473-->
<!-- Bootstrap 5 CDN-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/css/bootstrap.min.css" integrity="sha512-N415hCJJdJx+1UBfULt+i+ihvOn42V/kOjOpp1UTh4CZ70Hx5bDlKryWaqEKfY/8EYOu/C2MuyaluJryK1Lb5Q==" crossorigin="anonymous" />
<!-- End Bootstrap 5 CDN -->
<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoT Bay - Index Page</title>
    </head>
    <body>       
        <%
            Customer customer = new Customer(0);
            session.setAttribute("currentCustomer", customer);      
            session.setAttribute("currentCustomerID", customer.getCustomerId());
        %>
        <h1 class="display-1 text-center">Please Select One of the Following</h1>
        <div class="d-flex justify-content-evenly pt-5">
            <div class="row text-center">
                <a class="display-6 mt-5 text-decoration-none" href="Login.jsp">Login</a>
                <a class="display-6 mt-5 text-decoration-none" href="">Register</a>
                <a class="display-6 mt-5 text-decoration-none" href="CurrentOrderServlet">Continue as Guest</a>
            </div>
        </div>
    </body>
    <jsp:include page="/ConnServlet" flush="true"/>
</html>
