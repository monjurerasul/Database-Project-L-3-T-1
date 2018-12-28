<%-- 
    Document   : ViewAreaList
    Created on : 15-Dec-2016, 11:20:51
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Area"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Area List</title>
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
            
  Vector<Area> obj = (Vector<Area>)session.getAttribute("arealist");
  out.println("<tr>");
  out.println("<th>Area ID</th>");
  out.println("<th>Area Title</th>");
  out.println("</tr>");
  for(Area objc : obj){
  out.println("<tr>");
  out.print("<td>");
  out.print(objc.area_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.area_name);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  <br/><a href="MDHome.jsp"><button type="button">Back</button></a><br/>

    </body>
</html>
