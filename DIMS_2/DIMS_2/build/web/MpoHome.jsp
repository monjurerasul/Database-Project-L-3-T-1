<%-- 
    Document   : MpoHome
    Created on : 12-Dec-2016, 07:38:31
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MPO Home</title>
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
        
        <form method="post" action="RetailerListDisplay.do">
            <input type="submit" value="Post Order" />
        </form>
        <br/>
        
        <form method="post" action="ShowPreorder.do">
            <input type="submit" value="My Order" />
        </form>
        <br/>
         <a href="CreateNewRetailer.jsp"><button type="button">Add New Retailer</button></a><br/>
        <br/>
        <form method="post" action="LogOut.do">
            <input type="submit" value="Log Out" />
        </form>
    </body>
</html>
