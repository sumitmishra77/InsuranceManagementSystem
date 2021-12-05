<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="my.services.Claim"%>


<html>
    <head>
        <title>Registered Devices</title>
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
                href="admin_updateproduct.jsp"> Add Products </a> <a
                href="Admin_ReportControllerServlet"> Claims Report</a>
            <p>Welcome, ${user}
            <p>
            <div id="mySidenav" class="sidenav">

                <a href="register.jsp" id="blog"> &#8592; &nbsp;&nbsp;Logout</a>

            </div>
        </div>



        <!-- user is session variable id(serialnumber) is brought in from previous page  -->

        <%  List<Claim> claims = (ArrayList<Claim>) request.getAttribute("claims");%>


        <br/>

        <!-- display the result of query in table format -->
    <center>


        <table border="1" width="40%" id="table">

            <tr>


                <th>User Name</th>
                <th>Product Name</th> 
                <th>claim Date</th>                
                <th>Description</th>

                <th>Serial Number</th>

                <th>status</th>


            </tr>
            <% if (claims != null) {
                       for (Claim c : claims) {%>
            <tr>


                <td><%=c.getUserName()%></td>	
                <td><%=c.getProductName()%></td>
                <td><%=c.getClaimDate()%></td>
                <td><%=c.getDescription()%></td>

                <td><%=c.getSerialNumber()%></td>

                <td><%=c.getStatus()%></td>

            </tr> 
            <% }
                        }  %>

        </table>


        <% if (claims.isEmpty()) {%>
        <p> No claims found  for this product <p>
            <% }%>







    </center>
</body>
</html>