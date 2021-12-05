<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="my.services.RegisteredProduct"%>


<html>
    <head>
        <title>Registered Devices</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    </head>
    <body>

        <div class="topnav">
            <a href="ProductRegistrationControllerServlet">Register new Product</a> <a
                href="DisplayRegisteredProductsControllerServlet">View Registered Products</a>
            <p>Welcome, ${user}
            <p>
        </div>
        <div id="mySidenav" class="sidenav">

            <a href="register.jsp" id="blog"> &#8592; &nbsp;&nbsp;Logout</a>

        </div>

        <br>



    <center>

        <table border="1" width="40%" id="table">
            <caption>
                    <!-- "${user}" List -->
            </caption>
            <tr>



                <th>Product Name</th>
                <th>Serial Number</th>
                <th>Purchase Date</th>

                <th colspan="2" width="10%">Action</th>



            </tr>
            <% List<RegisteredProduct> list = (ArrayList) request.getAttribute("productList");
                                    for (RegisteredProduct rP : list) {%>

            <tr>

                <td><%=rP.getProductName()%></td>

                <td><%=rP.getSerialNumber()%></td>

                <td><%=rP.getPurchaseDate()%></td>

                <td><a href="AddClaimControllerServlet?id=<%=rP.getSerialNumber()%>">Add Claim</a></td>
                <td><a href="ViewClaimControllerServlet?id=<%=rP.getSerialNumber()%>">View Claim</a></td>


            </tr>

            <% }%>

        </table>



    </center>
</body>
</html>
