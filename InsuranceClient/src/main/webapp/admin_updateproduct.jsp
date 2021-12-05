<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <title>Update Product</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    </head>
    <body>
        <div class="topnav">
            <a href="Admin_UsersControllerServlet">Users Information</a> <a
                href="Admin_RegisteredProductControllerServlet"> Registered Products Information</a> 

            <a
                href="Admin_ProductControllerServlet"> Products Information</a> 

            <a

                <a
                href="Admin_ViewClaimControllerServlet">Claims Information</a> <a
                href="admin_updateproduct.jsp">  Add Products</a> <a
                href="Admin_ReportControllerServlet"> Claims Report</a>
            <p>Welcome, ${user} <p>
        </div>
        <div id="mySidenav" class="sidenav">

            <a href="register.jsp" id="blog">	&#8592; &nbsp;&nbsp;Logout</a>

        </div>

        <form method="post" action="Admin_UpdateProductControllerServlet">


            <center>
                <table border="0" cellspacing="2" cellpadding="5">
                    <thead>
                        <tr>
                            <th colspan="2">Purchase Product</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><label>Product Name</label></td>
                            <td><input type="text" name="pname"/></td>
                        </tr>
                        <tr>
                            <td><label>Serial Number:</label></td>
                            <td><input type="text" name="sno"/></td>
                        </tr>
                        <tr>
                            <td><label>Color:</label></td>
                            <td><input type="text" name="color"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Save" name="submit" /></td>
                            <td><input type="reset" value="reset"/></td>
                        </tr>
                    </tbody>
                </table>
        </form>

        <% if (request.getAttribute("msg") != null) {
                  if (request.getAttribute("msg").equals("exception")) { %>
        <font size="5" color='red'> Duplicate Serial number cannot add	 </font>

        <% } else {%>
        <font size="5" color='green'> Product added 	 </font>
        <% }
              }%>















    </center>
</body>
</html>
