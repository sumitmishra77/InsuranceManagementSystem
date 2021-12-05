<%-- 
    Document   : error
    Created on : 4-Aug-2021, 1:45:53 PM
    Author     : mishr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import=" my.models.Failed" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Failed fail = (Failed) request.getAttribute("failures"); %>

        <% if (fail.username.equalsIgnoreCase("invalid")) { %>

        <font size="5" color='red'>Login failed " Invalid username or Password ".<br/> <a href="login.jsp">Try again </a>or 
        <a href="register.jsp"> Register</a>
        </font>  

        <% } else {
                               if (fail.username.equalsIgnoreCase("empty")) { %>
        <font size="5" color='red'> UserName field is Empty </font><br/>


        <% }
                                     if (fail.password.equalsIgnoreCase("empty")) { %>
        <font size="5" color='red'> Password field is Empty </font><br/>


        <%  }
                                    if (fail.phonenumber.equalsIgnoreCase("empty")) { %>
        <font size="5" color='red'> Phone field is Empty </font> <br/>

        <%  }
                                     if (fail.phonenumber.equalsIgnoreCase("incorrect")) { %>
        <font size="5" color='red'> Phone number can be only 10 digits </font> <br/>

        <%}
                                     if (fail.email.equalsIgnoreCase("empty")) { %>
        <font size="5" color='red'> Email field is Empty </font><br/>
        <% }
                                     if (fail.email.equalsIgnoreCase("incorrect")) { %>
        <font size="5" color='red'> Email Incorrect format </font><br/>

        <%}
                                    if (fail.name.equalsIgnoreCase("empty")) { %>
        <font size="5" color='red'> Name field is Empty </font><br/>

        <%}%>

        <font size="5"> <a href="register.jsp">Try Again </a></font>

        <% }%>
    </body>
</html>
