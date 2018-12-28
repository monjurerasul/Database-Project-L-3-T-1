<%-- 
    Document   : ViewJobList
    Created on : 15-Dec-2016, 10:29:03
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Job"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job List</title>
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
            
  Vector<Job> obj = (Vector<Job>)session.getAttribute("joblist");
  out.println("<tr>");
  out.println("<th>Job ID</th>");
  out.println("<th>Job Title</th>");
  out.println("</tr>");
  for(Job objc : obj){
  out.println("<tr>");
  out.print("<td>");
  out.print(objc.job_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.job_title);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  <br/><a href="MDHome.jsp"><button type="button">Back</button></a><br/>

    </body>
</html>
