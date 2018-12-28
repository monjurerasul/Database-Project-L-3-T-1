<%-- 
    Document   : depository
    Created on : 12-Dec-2016, 20:58:48
    Author     : Hasan Murad
--%>

<%@page import="java.util.Vector"%>
<%@page import="Hasan.Models.Depository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Depository</title>
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
  Vector<Depository> obj = (Vector<Depository>)session.getAttribute("depository");
  out.println("<tr>");
  out.println("<th>Product ID</th>");
  out.println("<th>Product Name</th>");
  out.println("<th>Price</th>");
  out.println("<th>Quantity</th>");
  out.println("<tr>");
  for(Depository objc : obj){
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.PRODUCT_ID+"',");
  out.print("'"+objc.PRODUCT_NAME+"',");
  out.print("'"+objc.PRICE+"',");
  out.print("'"+objc.STOCK_AMOUNT+"'");
  out.println(")\">");
  out.print("<td>");
  out.print(objc.PRODUCT_ID);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.PRODUCT_NAME);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.PRICE);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.STOCK_AMOUNT);
  out.println("</td>");
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  <form method="post" action="Update_Depository.do" onsubmit="return validate()">
            Product ID: <label id="product_id1" ></label><br/>
            <input id="product_id" type="hidden" name="product_id" value="" />
            Product Name: <label id="product_name1" ></label><br/>
            <input id="product_name" type="hidden" name="product_name" value="" /> 
            Price: <label id="price1" ></label><br/><br/>
            <input id="price" type="hidden" name="price" value=""/>
            Enter Stock: <input id="quantity" type="text" name="quantity" value="" /> 
            <input type="submit" value="Update" /><br/>
   </form>
  <br/><a href="DepoManagerHome.jsp"><button type="button">Back</button></a><br/>

<script>
function myFunction(id,name,price,quantity) {
    document.getElementById("product_id").value =id;
    document.getElementById("product_name").value =name;
    document.getElementById("price").value =price;
    document.getElementById("quantity").value =quantity; 
    document.getElementById("product_id1").innerHTML =id;
    document.getElementById("product_name1").innerHTML =name;
    document.getElementById("price1").innerHTML =price;   
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
