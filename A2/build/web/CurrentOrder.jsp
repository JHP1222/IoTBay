<%-- Jaehyeon Peang (13742972) --%>

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
        <form action="ShowProductServlet">
            <table>
                <tr>
                    <td>Product ID: </td>
                    <td><input name="productID" type="text"></td>
                    <td><input type="submit" ></td>
                </tr>
            </table>         
        </form>
        <form action="ViewCartServlet" method="post">
            <input type="submit" value="View Cart"/>
        </form>
    </body>
</html>
