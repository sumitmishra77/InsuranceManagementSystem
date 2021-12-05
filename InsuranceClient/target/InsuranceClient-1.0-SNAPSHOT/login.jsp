<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    </head>
    <body>

        <div class="topnav">
            <a>Welcome to ABC Login<a>
                    </div>


                    <form method="post" action="LoginControllerServlet">

                        <div class="container" align="center">
                            <fieldset>
                                <h2>USER LOGIN :</h2>
                                <label for="uname"><b>Username</b></label>
                                <input type="text" placeholder="Enter Username" name="username"> 
                                <label for="psw"><b>Password</b></label>
                                <input type="password"	placeholder="Enter Password" name="password">
                                <button style="width: 200px;height: 40px" type="submit" name="register" value="true">Login</button>
                            </fieldset>
                        </div>








                        <br />
                        <center>

                            <a href="register.jsp">  <font size="5" color='green'>Go to registration Page</font> </a>


                        </center>




                    </form>
                    </body>
                    </html>

