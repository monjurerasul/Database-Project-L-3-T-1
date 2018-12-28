<%-- 
    Document   : Profile
    Created on : 12-Dec-2016, 17:49:45
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
          Employee obj = (Employee)session.getAttribute("user");
          out.println("ID : "+obj.employee_id+"<br/>");
          out.println("Password :"+ obj.password+"<br/>");
          out.println("First Name : "+obj.first_name+"<br/>");
          out.println("Last Name : "+obj.last_name+"<br/>");
          out.println("Area ID: "+obj.area_id+"<br/>");
          out.println("Salary : "+obj.salary+"<br/>");
          out.println("<br/>");
          out.print("<a href=\"");
          if(obj.job_id==3)out.print("MDHome.jsp");
          else if(obj.job_id==2)out.print("DepoManagerHome.jsp");
          else if(obj.job_id==1)out.print("MpoHome.jsp");
          out.print("\"><button type=\"button\">Back</button></a><br/>");
        %>
    </body>
</html>
