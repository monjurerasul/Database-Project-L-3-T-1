<%-- 
    Document   : MPOList
    Created on : 13-Dec-2016, 04:15:19
    Author     : Hasan Murad
--%>

<%@page import="java.util.Vector"%>
<%@page import="Hasan.Models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MPO List</title>
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
  out.println("<th>First Name</th>");
  out.println("<th>Last Name</th>");
  out.println("<tr>");
  for(Employee objc : obj){
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.employee_id+"',");
  out.print("'"+objc.first_name+"',");
  out.print("'"+objc.last_name+"'");
  out.println(")\">");
  out.print("<td>");
  out.print(objc.employee_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.first_name);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.last_name);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  
  <form method="post" action="MPORetailerList.do" onsubmit="return validate()">
            MPO ID:  <label id="employee_id1" ></label><br/><br/>
            <input id="employee_id" type="hidden" name="employee_id" value="a" />
            First Name: <label id="first_name1" ></label><br/><br/>
            <input id="first_name" type="hidden" name="first_name" value="a" /> 
            Last Name: <label id="last_name1" ></label><br/><br/>
            <input id="last_name" type="hidden" name="last_name" value="b"/> 
            <input type="submit" value="See Retailers"/><br/>
   </form>
   <br/><a href="DepoManagerHome.jsp"><button type="button">Back</button></a><br/>

<script>
function myFunction(id,fname,lname) {
    document.getElementById("employee_id").value =id;
    document.getElementById("first_name").value =fname;
    document.getElementById("last_name").value =lname;  
     document.getElementById("employee_id1").innerHTML =id;
    document.getElementById("first_name1").innerHTML =fname;
    document.getElementById("last_name1").innerHTML =lname;   
}
</script>
 <script>
            function validate() {
    if (document.getElementById("employee_id1").innerHTML == "") {
         alert("Select One MPO");
         return false;
    } else {
        return true;
    }
}
</script>

    </body>
    
</html>
