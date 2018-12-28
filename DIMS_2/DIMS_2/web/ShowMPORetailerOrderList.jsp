<%-- 
    Document   : ShowMPORetailerList
    Created on : 13-Dec-2016, 18:32:22
    Author     : Hasan Murad
--%>

<%@page import="Hasan.Models.orderproduct"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordered Product List</title>
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
  Vector<orderproduct> obj = (Vector<orderproduct>)session.getAttribute("orderproduct");
  out.println("<tr>");
  out.println("<th>Product ID</th>");
  out.println("<th>Product Name</th>");
  out.println("<th>Price</th>");
  out.println("<th>Quantity</th>");
  out.println("<th>Status</th>");
  out.println("<tr>");
  for(orderproduct objc : obj){
    
  out.println("<tr");
  out.print(" onclick=\"myFunction(");
  out.print("'"+objc.PRODUCT_ID+"',");
  out.print("'"+objc.product_name+"',");
  out.print("'"+objc.price+"',");
  out.print("'"+objc.QUANTITY+"',");
  out.print("'"+objc.status+"'");
  out.println(")\">");
  out.print("<td>");
  out.print(objc.PRODUCT_ID);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.product_name);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.price);
  out.println("</td>");
  out.print("<td>");
  out.print(objc.QUANTITY);
  out.println("</td>");
  out.print("<td >");
  if(objc.status==0)out.print("Pending....");
  else if(objc.status==1)out.print("Updated Comfirm");
  else if(objc.status==2)out.print("Comfirmed");
  out.println("</td>");   
  out.println("</tr>");
  }
  %>
  </table>
  <br/>
  
  <form method="post" action="TempUpdateMPORetailerOrderList.do" onsubmit="return validate()">
             Product ID: <label id="product_id1" ></label><br/>
            <input id="product_id" type="hidden" name="product_id" value="" />
            Product Name: <label id="product_name1" ></label><br/>
            <input id="product_name" type="hidden" name="product_name" value="" /> 
            Price: <label id="price1" ></label><br/>
            <input id="price" type="hidden" name="price" value=""/>
            <input id="status" type="hidden" name="status" value=""/>
            Enter Quantity: <input id="quantity" type="text" name="quantity" value=""/><br/><br/>
            <input type="submit" value="Add to comfirm chart"/><br/><br/>
   </form>
   <form method="post" action="UpdateDepositoryOrderProduct.do">
        <input type="submit" value="Confirm Order"/><br/>
   </form>    

  <br/><a href="MPORetailerList.jsp"><button type="button">Back</button></a><br/>
<script>
function myFunction(pid,pname,p,q,s) {
    document.getElementById("product_id").value =pid;
    document.getElementById("product_name").value =pname;
    document.getElementById("price").value =p;  
    document.getElementById("quantity").value =q;  
    document.getElementById("status").value =s;
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
        if(ocument.getElementById("status").value=="0")return true;
        else{
            alert("Only Update Pending Order");
            return false;
        }
    }
}
 </script>

    <body/>
</html>
