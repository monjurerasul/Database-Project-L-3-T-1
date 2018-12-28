<%-- 
    Document   : ProductList
    Created on : 13-Dec-2016, 12:17:31
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Products"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
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
            
  Vector<Products> obj = (Vector<Products>)session.getAttribute("productlist");
  out.println("<tr>");
  out.println("<th>Product ID</th>");
  out.println("<th>Product Name</th>");
  out.println("<th>Price</th>");
  out.println("<th>Quantity</th>");
  out.println("<tr>");
  for(Products objc : obj){
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.product_id+"',");
  out.print("'"+objc.product_name+"',");
  out.print("'"+objc.price+"',");
  out.print("'"+objc.quantity+"'");
  out.println(")\">");
  out.print("<td>");
  out.print(objc.product_id);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.product_name);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.price);
  out.println("</td>");
  out.print("<td>");
  if(objc.quantity==0)out.print(" ");
  else out.print(objc.quantity);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  
  <form method="post" action="AddToChart.do" onsubmit="return validate()">
            Product ID: <label id="product_id1" ></label><br/>
            <input id="product_id" type="hidden" name="product_id" value="" />
            Product Name: <label id="product_name1" ></label><br/>
            <input id="product_name" type="hidden" name="product_name" value="" /> 
            Price: <label id="price1" ></label><br/>
            <input id="price" type="hidden" name="price" value=""/>
            Enter Quantity: <input id="quantity" type="text" name="quantity" value=""/><br/>
            <input type="submit" value="Add to chart"/><br/><br/>
   </form>
   <form method="post" action="UpdateOrderProduct.do">
        <input type="submit" value="Confirm Order"/><br/>
   </form>    
  <br/><a href="RetailerList.jsp"><button type="button">Back</button></a><br/>

<script>
function myFunction(pid,pname,p,q){
    document.getElementById("product_id").value =pid;
    document.getElementById("product_name").value =pname;
    document.getElementById("price").value =p;  
    document.getElementById("quantity").value =q;  
    document.getElementById("product_id1").innerHTML =pid;
    document.getElementById("product_name1").innerHTML =pname;
    document.getElementById("price1").innerHTML =p;   
}
</script>

 <script>
            function validate() {
    if (document.getElementById("quantity").value == "" || document.getElementById("product_id").value=="" ){
         alert("Enter Quantity");
         return false;
    } else {
        return true;
    }
}
 </script>
    </body>
</html>
