<%-- 
    Document   : ViewTypeList
    Created on : 15-Dec-2016, 11:28:35
    Author     : Hasan Murad
--%>


<%@page import="Hasan.Models.type"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Type List</title>
     <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
</style>
    </head>
    <body>
        <table> 
        <%
            
  Vector<type> obj = (Vector<type>)session.getAttribute("typelist");
  out.println("<tr>");
  out.println("<th>Type ID</th>");
  out.println("<th>Type Title</th>");
  out.println("</tr>");
  for(type objc : obj){
  out.println("<tr>");
  out.print("<td>");
  out.print(objc.type_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.type_name);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  <br/><a href="MDHome.jsp"><button type="button">Back</button></a><br/>

    </body>
</html>
