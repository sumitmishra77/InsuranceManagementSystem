<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>ABC Company</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    </head>
    <body>



        <form method="post" action="RegisterControllerServlet" style="border:1px solid #ccc">


                           <center>

                               <div style="margin-top: 10px" class="box">
               
                    
                        <img src="images/abc.PNG" width="300px" height="250px"/>
                        
                   
                    
                    
                </div>
                <div class="content">
                    <h2> Welcome to ABC Company  </h2>
                    <h3> Trust us With Your devices....</h3>
                     </center>
                    <div class="container signin" align="center">
                        <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
                    </div>
                </div>

            </div>
            <hr height="10%">
            <div class="container" align="center">

                <h3>New User ??? </h3>
                <h3>Sign Up Below : </h3>



                <fieldset>
                    <p>Please fill in this form to create an account.</p>
                    <hr>



                    <label for="username"><b>Username:</b></label> 
                    <input type="text" name="username" id="name" placeholder="Enter username..."><br>
                    <br> 

                    <label for="password"><b> Password:</b></label> 
                    <input type="password" name="password" id="name" placeholder="Enter your password..."><br>
                    <br> 

                    <label for="email"><b>Email :</b></label>
                    <input type="text" name="email" id="email" class="form-control" placeholder="John@test.ca"><br>



                    <label for="phone"><b>Cellphoneno :</b></label>
                    <input type="text" id="phone" name="phone" class="form-control" placeholder="1234567890"> <br><br>

                    <label for="phone"><b>Name : </b></label>
                    <input type="text" id="phone" name="name" class="form-control"> <br><br>


                    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

                    <div class="clearfix">
                        <button style="width: 300px" type="reset" class="cancelbtn">Reset</button>
                        <button style="width: 300px" type="submit" class="signupbtn" name="register" value="true">Register</button>
                    </div>

                </fieldset>


            </div>
        </form>






    </body>
</html>