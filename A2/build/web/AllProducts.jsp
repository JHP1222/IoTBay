<%-- 
Ben Cornwell - 13919473
--%>
<!-- Bootstrap 5 CDN-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/css/bootstrap.min.css" integrity="sha512-N415hCJJdJx+1UBfULt+i+ihvOn42V/kOjOpp1UTh4CZ70Hx5bDlKryWaqEKfY/8EYOu/C2MuyaluJryK1Lb5Q==" crossorigin="anonymous" />
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Products</title>
    </head>
    <body>
        <%
            ArrayList<Product> inventory = (ArrayList<Product>) session.getAttribute("inventory");
        %>
        <h1 class="display-1 text-center">View All Products</h1>
        <div class="container col-6 mt-5">
            <form method="post" action="ProductSearchResultsServlet">
                <div class="row">
                    <div class="col-8">
                        <input class="form-control form-control-lg" type="text" id="searchValue" name="searchValue" placeholder="Search by Name or Type">
                    </div>
                    <div class="col-4">
                        <input type="submit" class="btn btn-lg text-light btn-info" value="Search!">
                    </div>
                </div>
                <div class="h3 text-center mt-5">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="searchRadio" id="searchRadio" value="name" checked>
                        <label class="form-check-label" for="name">Search by Name</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="searchRadio" id="searchRadio" value="type">
                        <label class="form-check-label" for="type">Search by Type</label>
                    </div>
                </div>
            </form>
        </div>

        <div class="container col-8 table-responsive mt-5">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>
                            Product ID
                        </th>
                        <th>
                            Product Name
                        </th>
                        <th>
                            Product Type
                        </th>
                        <th>
                            Product Price
                        </th>
                        <th>
                            Product Quantity
                        </th>
                        <th>
                            Add To Cart
                        </th>
                    </tr>
                </thead>
                <tbody class="table-info">
                    <%
                        if (inventory != null) {
                            for (Product p : inventory) {
                    %>
                    <tr>
                        <td><p><%=p.getProductID()%></p></td>
                        <td><p><%=p.getProductName()%></p></td>
                        <td><p><%=p.getProductType()%></p></td>
                        <!--Formatting double depending on decimals 40.0 -> $40.00. 39.99 -> $39.99-->
                        <%if (p.getProductPrice() % 1 == 0) {%>
                        <td><p>$<%=p.getProductPrice()%>0</p></td>
                        <%} else {%>
                        <td><p>$<%=p.getProductPrice()%></p></td>
                        <%}%>
                        <td><p><%=p.getProductQuantity()%> Units</p></td>
                        <td><a href="ShowProductServlet?id=<%=p.getProductID()%>" class="btn btn-black"> Add To cart</a> </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <% } else {%>
        <p>There are no products in the database!</p>
        <%}%>
        <div style="text-align: center" class="col-12">
            <a class="display-6 text-center text-decoration-none" href = "index.jsp">Go Back</a>
        </div>
    </body>
</html>