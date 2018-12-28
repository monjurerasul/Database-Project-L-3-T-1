<%-- 
    Document   : UpdateMPOList
    Created on : 14-Dec-2016, 15:44:11
    Author     : Hasan Murad
--%>

<%@page import="java.util.Vector"%>
<%@page import="Hasan.Models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
  Vector<Employee> obj = (Vector<Employee>)session.getAttribute("mpolist");
  out.println("<tr>");
  out.println("<th>MPO ID</th>");
  out.println("<th>Password</th>");
  out.println("<th>First Name</th>");
  out.println("<th>Last Name</th>");
  out.println("<th>Area ID</th>");
  out.println("<th>Salary</th>");
  out.println("<tr>");
  for(Employee objc : obj){
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.employee_id+"',");
  out.print("'"+objc.first_name+"',");
  out.print("'"+objc.last_name+"',");
  out.print("'"+objc.area_id+"',");
  out.print("'"+objc.salary+"',");  
  out.print("'"+objc.password+"'");
  out.println(")\">");
  out.print("<td>");
  out.print(objc.employee_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.password);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.first_name);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.last_name);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.area_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.salary);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  
  <form method="post" action="UpdateMPOTable.do" onsubmit="return validate()">
            Employee ID: <label id="employee_id1" ></label><br/>
            <input id="employee_id" type="hidden" name="employee_id" value="" />
            Enter Password: <input id="password" type="text" name="password" value=""/><br/>
            Enter First Name: <input id="first_name" type="text" name="first_name" value="" /> <br/>
            Enter Last Name: <input id="last_name" type="text" name="last_name" value=""/> <br/>
            Area ID: <label id="area_id1" ></label><br/>
            <input id="area_id" type="hidden" name="area_id" value=""/> 
            Enter Salary: <input id="salary" type="text" name="salary" value=""/> <br/>
             
            <input type="submit" value="Update"/><br/>
   </form>
 
<br/><a href="DepoManagerHome.jsp"><button type="button">Back</button></a><br/>
<script>
function myFunction(id,fname,lname,aid,sal,pass) {
    document.getElementById("employee_id").value =id;
    document.getElementById("first_name").value =fname;
    document.getElementById("last_name").value =lname;
    document.getElementById("area_id").value =aid;
    document.getElementById("salary").value =sal;
    document.getElementById("password").value =pass;
    document.getElementById("employee_id1").innerHTML =id;
     document.getElementById("area_id1").innerHTML =aid;
}
</script>

<script>
            function validate() {
    if (document.getElementById("employee_id").value == "" || document.getElementById("first_name").value==""||document.getElementById("last_name").value == ""||document.getElementById("area_id").value == ""||document.getElementById("salary").value == ""||document.getElementById("password").value == "" ){
         alert("Enter ALL fields");
         return false;
    } else {
        return true;
    }
}
 </script>
 
    </body>
</html>
