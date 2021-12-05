<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Claim status</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    </head>
    <body>
        <div class="topnav">
            <a href="Admin_ViewClaimControllerServlet"> &#8592; Go back to Claims page</a>
            <p>Welcome, ${user}
            <p>
        </div>



        <br>
        <br>
        <font size="5" color='blue'> The claim status is :${status}
        </font>

        <br />










    </body>
</html>
