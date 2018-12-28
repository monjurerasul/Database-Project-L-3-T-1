<%-- 
    Document   : SuccessfulCreateNewDMAccount
    Created on : 14-Dec-2016, 11:19:56
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
              Employee obj = (Employee) session.getAttribute("NewDM");
              out.println("ID : "+obj.employee_id+"<br/>");
              out.println("Password :"+ obj.password+"<br/>");
              out.println("First Name : "+obj.first_name+"<br/>");
              out.println("Last Name : "+obj.last_name+"<br/>");
              out.println("Area ID: "+obj.area_id+"<br/>");
              out.println("Salary : "+obj.salary+"<br/>");
              
           %>
           <br/>
        <a href="MDHome.jsp"><button type="button">Back</button></a><br/>
        <br/>
    </body>
</html>
