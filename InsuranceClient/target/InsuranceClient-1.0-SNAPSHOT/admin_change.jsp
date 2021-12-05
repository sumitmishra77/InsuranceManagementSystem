
<%@page import="my.services.Claim"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Claims</title>
        <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    </head>
    <body>
        <div class="topnav">
            <a href="Admin_ViewClaimControllerServlet"> &#8592; Go back to Claims page</a>
            <p>Welcome, ${user}
            <p>
        </div>
        <form method="post" action="Admin_ChangedbControllerServlet">

            <center>

            <!-- dispaly the claim fields from the claim table for a particular claim with the count on claims made on a serialnumber -->

            <table border="1" width="70%" id="table">
                <caption>Approve / Deny claim</caption>
                <tr>
                    <th>User Name</th>
                    <th>Claim Date</th>
                    <th>Description</th>
                    <th>Serial Number</th>
                    <th>Claims Approved</th>
                    <th colspan="3" width="10%">Status</th>

                </tr>
                <% Claim claim = (Claim) request.getAttribute("claim");%>

                <tr align="center">
                <input type="hidden" name="id" value="<%=claim.getId()%>">
                <td><%=claim.getUserName()%></td>
                <td><input type="text" name="claimdate"	value="<%=claim.getClaimDate()%>" readonly /></td>
                <td><%=claim.getDescription()%></td>
                <td><%=claim.getSerialNumber()%></td>
                <td> ${claimCount}</td>
                <td>Approve <input type="radio" name="status" value="Approved"></td>
                &nbsp;&nbsp;&nbsp;
                <td>Deny <input type="radio" name="status" value="Deny"
                                checked></td>
                <td><input type="submit" name="action" value="update" /></td>

                </tr>


            </table>
            </center>


        </form>





    </body>
</html>
