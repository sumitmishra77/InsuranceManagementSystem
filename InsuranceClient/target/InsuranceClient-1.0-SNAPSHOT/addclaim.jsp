<%@page import="my.services.RegisteredProduct"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<html>
    <head>
        <title>Registered Devices</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    </head>
    <body>

        <!-- code for navigation bar -->
        <div class="topnav">
            <a href="ProductRegistrationControllerServlet">Register new Product</a> <a
                href="DisplayRegisteredProductsControllerServlet">View Registered Products</a>
            <p>Welcome, ${user}
            <p>
            <div id="mySidenav" class="sidenav">

                <a href="register.jsp" id="blog"> &#8592; &nbsp;&nbsp;Logout</a>

            </div>
        </div>
        <br />


        <!-- user is session variable id is brought in from previous page and this id(serialnumber) it used to get the product name from product table -->

    </div>



    <!-- excute this block on submit button -->

    <!-- this block inserts data to claim table -->









    <!-- check if claim date is within 5 years from purchase date -->





    <!--		<font size="5" color='green'> Claim Submitted Successfully !
                    </font> -->
<center>

    <form method="post" action="AddClaimControllerServlet">



        <br>
        <table border="1" width="85%" id="table">
            <caption>
                <% RegisteredProduct product = (RegisteredProduct) request.getAttribute("product");
                    String pattern = "MM-dd-yyyy";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                        String today = simpleDateFormat.format(new Date());%>
            </caption>
            <tr>
                <!-- <th>Username</th> -->
                <th>Productname</th>
                <th>serialnumber</th>
                <th>claimdate</th>
                <th>description</th>

                <th colspan="2" width="10%">Action</th>

            </tr>
            <input type="hidden" value="${user}" name="username" readonly />

            <tr>

                <td width="30%"><input type="text" value="<%=product.getProductName()%>"
                                       name="productname" readonly /></td>
                <td><input type="text" value="<%=product.getSerialNumber()%>" name="sno"
                           readonly /></td>


                <td width="30%"><input type="text" name="claimdate"
                                       value="<%=today%>" readonly /></td>
                <td width="45%"><input type="text" name="description"
                                       value="" placeholder="enter claim description" /></td>


                <td><input type="submit" name="add" value="addclaim" /></td>



            </tr>



        </table>


    </form>
    <% if (request.getAttribute("msg") != null) {
                                                        if (request.getAttribute("msg").equals("failure")) { %>
    <font size="5" color='red'> Three claims already approved on
    the Product no new claims can be submitted. </font>
    <% }
                                                    if (request.getAttribute("msg").equals("success")) { %>

    <br>
    <font size="5" color='green'> Claim Submitted
    </font>
    <% }
                                                     if (request.getAttribute("msg").equals("Blank")) { %>
    <font size="5" color='red'> Description required
    </font> 


    <%  }
                                                      }%>

    <br>

</center>
</body>
</html>
