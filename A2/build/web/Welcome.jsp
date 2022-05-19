
<%@page import="uts.isd.model.Order"%>
<!-- Bootstrap 5 CDN-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/css/bootstrap.min.css" integrity="sha512-N415hCJJdJx+1UBfULt+i+ihvOn42V/kOjOpp1UTh4CZ70Hx5bDlKryWaqEKfY/8EYOu/C2MuyaluJryK1Lb5Q==" crossorigin="anonymous" />
<!-- End Bootstrap 5 CDN -->
<%@page import="uts.isd.model.Customer"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoT Bay - Welcome Page</title>
    </head>
    <body>
        <% 
        Customer customer = (Customer) session.getAttribute("currentCustomer");
        if(customer.getCustomerId() == 0){
            Order newGuestOrder = new Order();
            session.setAttribute("currentOrder", newGuestOrder);
            
            int customerID = customer.getCustomerId();
            session.setAttribute("currentCustomerID", customerID); 
        }
        else{        
            customer = (Customer) session.getAttribute("currentCustomer");
            int customerID = Integer.parseInt(session.getAttribute("currentCustomerID").toString());          
            Order newCustomerOrder = new Order(customerID);
            session.setAttribute("currentOrder", newCustomerOrder);
        }       
        if (customer.getCustomerId() == 0) { %>
        <h1 class="display-1 text-center">Welcome to the IoTBay, you are currently Logged in as Guest!</h1>     
        <% } else { %>
            <h2 class="display-1">Welcome to IoTBay, </h2>
            <p>Currently logged in as id = ${currentCustomerID} 
            </p>
        <% } %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">IoTBay</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="Welcome.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="allProductsServlet">Search</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="CartPage.jsp">Cart</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="OrderHistoryServlet">Views Orders</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Payment Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Shipping Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Management.jsp">Management</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>        

        
        <div class="d-flex justify-content-evenly pt-5">
            <div class="row text-center">
                <a class="display-6 mt-5 text-decoration-none" href="AllProductsServlet">Start Shopping!</a>
            </div>
        </div>
          
    </body>
    <jsp:include page="/ConnServlet" flush="true"/>
</html>