<%-- 
    Document   : UpdateProductList
    Created on : 14-Dec-2016, 12:24:30
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.Products"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
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
  out.println("<tr>");
  for(Products objc : obj){
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.product_id+"',");
  out.print("'"+objc.product_name+"',");
  out.print("'"+objc.price+"'");
  
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
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  
  <form method="post" action="UpdateProductTable.do" onsubmit="return validate()">
            Product ID: <label id="product_id1" ></label><br/>
            <input id="product_id" type="hidden" name="product_id" value="" />
            Enter Product Name: <input id="product_name" type="text" name="product_name" value="" /> <br/>
            Enter Price: <input id="price" type="text" name="price" value=""/><br/>
            
            <input type="submit" value="Update"/><br/>
   </form>
   <br/>
        <a href="MDHome.jsp"><button type="button">Back</button></a><br/>
        <br/>

<script>
function myFunction(pid,pname,p) {
    document.getElementById("product_id").value =pid;
    document.getElementById("product_name").value =pname;
    document.getElementById("price").value =p; 
    document.getElementById("product_id1").innerHTML =pid;
}
</script>

<script>
            function validate() {
    if (document.getElementById("product_id").value==""||document.getElementById("product_name").value==""||document.getElementById("price").value=="" ){
         alert("Enter All Fields");
         return false;
    } else {
        return true;
    }
}
 </script>
 
    </body>
</html>
