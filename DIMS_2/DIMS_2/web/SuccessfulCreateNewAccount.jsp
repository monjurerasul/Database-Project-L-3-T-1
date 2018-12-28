<%-- 
    Document   : SuccessfulCreateNewAccount
    Created on : 12-Dec-2016, 20:23:10
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New MPO Account</title>
    </head>
    <body>
        <h1>Successful MPO New Account Created</h1><br/>
        <%
            Employee obj=(Employee)session.getAttribute("newmpo");
          out.println("ID : "+obj.employee_id+"<br/>");
          out.println("Password :"+ obj.password+"<br/>");
          out.println("First Name : "+obj.first_name+"<br/>");
          out.println("Last Name : "+obj.last_name+"<br/>");
          out.println("Area ID: "+obj.area_id+"<br/>");
          out.println("Salary : "+obj.salary+"<br/>");
          out.println("<br/>");
            %>
        <br/>
        <a href="DepoManagerHome.jsp"><button type="button">Back</button></a><br/>
        <br/>
    </body>
</html>
