<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <a href="Admin_UsersControllerServlet">Users Information</a> <a
                href="Admin_RegisteredProductControllerServlet"> Registered Products Information</a> 

            <a
                href="Admin_ProductControllerServlet"> Products Information</a> 

            <a
                href="Admin_ViewClaimControllerServlet">Claims Information</a> <a
                href="admin_updateproduct.jsp">  Add Products</a> <a
                href="Admin_ReportControllerServlet"> Claims Report</a>
            <p>Welcome,"${user}"
            <p>
            <div id="mySidenav" class="sidenav">

                <a href="register.jsp" id="blog"> &#8592; &nbsp;&nbsp;Logout</a>

            </div>
        </div>
        <form method="post" action="Admin_UsersControllerServlet">
            <label>Enter User Name: </label> <input type="text" name="uname"
                                                    id="search"> <input type="submit" name="search" value="find">

            <center>
                <!-- code for displaying values fetched from db -->
                <% List<User> users = (ArrayList<User>) request.getAttribute("usersList");

                    if (users != null) {
                %>
                <table border="1" width="40%" id="table">
                    <caption>User List</caption>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Cellphone</th>
                        <th>email</th>
                        <th>name</th>

                    </tr>
                    <% for (User user : users) {
                    %>	
                    <tr>
                        <td> <%=user.getUsername()%>   </td>
                        <td><%=user.getPassword()%></td>
                        <td> <%=user.getCellphone()%></td>
                        <td> <%=user.getEmail()%> </td>
                        <td> <%=user.getName()%></td>


                    </tr>
                    <% }
                                            }%>


                </table>



            </center>
        </form>
    </body>
</html>