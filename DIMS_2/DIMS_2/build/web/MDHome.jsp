<%-- 
    Document   : MDHome
    Created on : 13-Dec-2016, 20:10:10
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MD Home</title>
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
        
        <a href="Profile.jsp"><button type="button">My Profile</button></a><br/><br/>
         
        <a href="CreateDMAccount.jsp"><button type="button">Add New DM</button></a><br/>
        <br/>
        <a href="CreateProduct.jsp"><button type="button">Add New Product</button></a><br/>
        <br/>
        <form method="post" action="ShowProductList.do">
            <input type="submit" value="Update Product" />
        </form>
        <br/>
        <form method="post" action="ShowDMList.do">
            <input type="submit" value="Update DM" />
        </form>
        <br/>
        <form method="post" action="ShowJobList.do">
            <input type="submit" value="Jobs" />
        </form>
        <br/>
        <form method="post" action="ShowAreaList.do">
            <input type="submit" value="Areas" />
        </form>
        <br/>
        <form method="post" action="ShowTypeList.do">
            <input type="submit" value="Product Types" />
        </form>
        <br/>
        <a href="CreateNewJob.jsp"><button type="button">Add New Job</button></a><br/>
        <br/>
        <a href="CreateNewArea.jsp"><button type="button">Add New Area</button></a><br/>
        <br/>
        <a href="CreateNewType.jsp"><button type="button">Add New Product Type</button></a><br/>
        <br/>
        <form method="post" action="LogOut.do">
            <input type="submit" value="Log Out" />
        </form>
        
    </body>
</html>
