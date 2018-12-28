<%-- 
    Document   : RetailerList
    Created on : 13-Dec-2016, 11:15:27
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Retailer"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retailer List</title>
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
  Vector<Retailer> obj = (Vector<Retailer>)session.getAttribute("retailerlist");
  out.println("<tr>");
  out.println("<th>Retailer ID</th>");
  out.println("<th>Retailer Name</th>");
  out.println("<th>Address</th>");
  out.println("<tr>");
  for(Retailer objc : obj){
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.retailer_id+"',");
  out.print("'"+objc.retailer_name+"',");
  out.print("'"+objc.address+"'");
  out.println(")\">");
  out.print("<td>");
  out.print(objc.retailer_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.retailer_name);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.address);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  
  <form method="post" action="ProductList.do" onsubmit="return validate()">
            Retailer ID: <label id="retailer_id1" ></label><br/>
            <input id="retailer_id" type="hidden" name="retailer_id" />
            Retailer Name: <label id="retailer_name1" ></label><br/>
            <input id="retailer_name" type="hidden" name="retailer_name" /> 
            Address: <label id="address1" ></label><br/><br/>
            <input id="address" type="hidden" name="address"/> 
            <input type="submit" value="See Products"/><br/>
   </form>
  <br/><a href="MpoHome.jsp"><button type="button">Back</button></a><br/>

<script>
function myFunction(rid,rname,rad) {
    document.getElementById("retailer_id").value =rid;
    document.getElementById("retailer_name").value =rname;
    document.getElementById("address").value =rad;  
    document.getElementById("retailer_id1").innerHTML =rid;
    document.getElementById("retailer_name1").innerHTML =rname;
    document.getElementById("address1").innerHTML =rad; 
}
</script>
 <script>
            function validate() {
    if (document.getElementById("retailer_id1").innerHTML == "") {
         alert("Select One Retailer");
         return false;
    } else {
        return true;
    }
}
</script>

    </body>
</html>
