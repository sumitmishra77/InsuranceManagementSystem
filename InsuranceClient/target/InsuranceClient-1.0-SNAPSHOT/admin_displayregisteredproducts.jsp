<%@page import="my.services.RegisteredProduct"%>

<%@page import="java.util.List;" %>
<%@page import="java.util.ArrayList;" %>
<%@page import="my.services.User;" %>

<html>
    <head>
        <title>Select Operation</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">

    </head>
    <body>
        <!-- code for navigation bar -->
        <div class="topnav">
            <a href="Admin_UsersControllerServlet">Users Information</a> 
            <a href="Admin_RegisteredProductControllerServlet"> Registered Products Information</a>

            <a
                href="Admin_ProductControllerServlet"> Products Information</a> 

            <a


                <a href="Admin_ViewClaimControllerServlet">Claims Information</a> 
            <a href="admin_updateproduct.jsp"> Add Products </a>
            <a href="Admin_ReportControllerServlet"> Claims Report</a>
            <p>Welcome,"${user}"
            <p>
            <div id="mySidenav" class="sidenav">

                <a href="register.jsp" id="blog"> &#8592; &nbsp;&nbsp;Logout</a>

            </div>
        </div>
        <form method="post" action="Admin_RegisteredProductControllerServlet">
            <label>Enter Product Name : </label> <input type="text" name="productname"
                                                        id="search"> <input type="submit" name="search" value="find">

            <center>
                <!-- code for displaying values fetched from db -->
                <% List<RegisteredProduct> productList = (ArrayList<RegisteredProduct>) request.getAttribute("products");

                    if (productList != null) {
                %>
                <table border="1" width="40%" id="table">
                    <caption>Registered Product List</caption>
                    <tr>
                        <th>Username</th>
                        <th>Product Name</th>
                        <th>Serial number</th>
                        <th>Purchase date</th>


                    </tr>
                    <% for (RegisteredProduct p : productList) {
                    %>	
                    <tr>
                        <td> <%=p.getUserName()%>   </td>
                        <td><%=p.getProductName()%></td>
                        <td> <%=p.getSerialNumber()%></td>
                        <td> <%=p.getPurchaseDate()%> </td>



                    </tr>
                    <% }
                                            }%>


                </table>



            </center>
        </form>
    </body>
</html>