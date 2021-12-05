<%@page import="java.util.ArrayList"%>
<%@page import="my.services.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>




<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Product Registration</title>

        <link rel="stylesheet" type="text/css" href="css/mystyle.css">

    </head>
    <body>


        <form method="get" action="ProductRegistrationControllerServlet"> 




            <!-- code for navigation bar -->
            <div class="topnav">
                <p>Welcome, ${user} <p>
            </div>

            <div class="topnav">
                <a href="ProductRegistrationControllerServlet">Register new Product</a>
                <a href="DisplayRegisteredProductsControllerServlet">View Registered Products</a>
               <!-- <p>Welcome, ${user} <p> -->
            </div>
            <div id="mySidenav" class="sidenav">

                <a href="register.jsp" id="blog">	&#8592; &nbsp;&nbsp;Logout</a>

            </div>



            <div class="container">

                <fieldset>
                    <h3>REGISTER PRODUCT</h3>



                    <label for="username"><b>Username:</b></label> 
                    <input type="text" name="username" id="name"  placeholder="Enter your username..." value="${user}" readonly>
                    <br> 





                    <label for="Pname"><b> Product name: </b></label> 
                    <select name="productname" class="form-control">
                        <% List<Product> product = (ArrayList<Product>) request.getAttribute("availableProducts");
                        for (Product p : product) {%>
                        <option value=<%=p.getProductName()%>> <%=p.getProductName()%>
                        </option>
                        <% }%>   
                    </select>


                    <br>
                    <br> 

                    <label for="serialno"><b>Serial No :</b></label>
                    <input type="text" name="serialno" ><br>



                    <label for="date"><b>Purchase Date :</b>  {REQUIRED FORMAT : DD-MM-YY }</label>

                    <br>
                    <input type="text" name="date" placeholder="DD-MM-YY"> 



                    <br> <br> <button type="submit" name="action" value="Register">Register</button>
                </fieldset>
            </div>


            <!-- check the serial number in product table -->




            <!-- check the serial number in productregistration table -->

            <% if (request.getAttribute("error") != null) { %>
            <p style="color:red;font-size:46px;"  > ${error} </p>
            <%  }%>








        </form> 
    </body>
</html>



