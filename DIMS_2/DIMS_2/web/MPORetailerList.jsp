<%-- 
    Document   : orderproductlist
    Created on : 13-Dec-2016, 10:26:10
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Retailer"%>
<%@page import="Hasan.Models.orderproduct"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retailer</title>
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
  out.println("<tr>");
  for(Retailer objc : obj){
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.getRetailer_id()+"',");
  out.print("'"+objc.getRetailer_name()+"'");
  out.println(")\">");
  out.print("<td>");
  out.print(objc.retailer_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.retailer_name);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  
  <form method="post" action="ShowMPORetailerList.do" onsubmit="return validate()">
            Retailer ID: <label id="retailer_id1" ></label><br/>
            <input id="retailer_id" type="hidden" name="retailer_id" />
            Retailer Name: <label id="retailer_name1" ></label><br/><br/>
            <input id="retailer_name" type="hidden" name="retailer_name" /> 
            <input type="submit" value="Comfirm"/><br/>
   </form>
  
  <br/><a href="MPOList.jsp"><button type="button">Back</button></a><br/>
 

<script>
function myFunction(rid,rname) {
    document.getElementById("retailer_id").value =rid;
    document.getElementById("retailer_name").value =rname; 
    document.getElementById("retailer_id1").innerHTML =rid;
    document.getElementById("retailer_name1").innerHTML =rname;
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
