<%-- 
    Document   : DepoManagerHome
    Created on : 12-Dec-2016, 09:25:24
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DM Home</title>
    </head>
    <body>
        
        <%
            Employee user= (Employee)session.getAttribute("user");
            if(user==null)
            {
                RequestDispatcher rd= request.getRequestDispatcher("LogInPage.jsp");
                rd.forward(request, response);
            }
            else out.println("<h1 padding=\"20px\">WelCome "+user.getFirst_name()+" "+user.getLast_name()+"</h1>");
            %>
        <a href="Profile.jsp"><button type="button">My Profile</button></a><br/>
        <br/>
        <form method="post" action="MPOListDisplay.do">
            <input type="submit" value="Order" />
        </form>
        <br/>
        <a href="CreateNewAccount.jsp"><button type="button">Add New MPO</button></a><br/>
        <br/>
        <form method="post" action="DepositoryDisplay.do">
            <input type="submit" value="Depository" />
        </form>
        <br/>
        <form method="post" action="ShowMPOList.do">
            <input type="submit" value="Update MPO" />
        </form>
        <br/>
        <form method="post" action="LogOut.do">
            <input type="submit" value="Log Out" />
        </form>
    </body>
</html>
