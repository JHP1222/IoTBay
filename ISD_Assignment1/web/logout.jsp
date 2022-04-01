<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <h1>Logout of IoTBay</h1>
        <%
            String name = request.getParameter("name");
        %>
        <h1>We hoped you enjoyed your browsing experience <%= name %>!</h1>
        <a href="index.html">Logout</a>
        <%session.invalidate(); %>
    </body>
</html>
