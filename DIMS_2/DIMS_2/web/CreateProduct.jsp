<%-- 
    Document   : CreateProduct
    Created on : 14-Dec-2016, 11:48:49
    Author     : Hasan Murad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Product</title>
    </head>
    <body>
        <form method="post" action="AddNewProduct.do" onsubmit="return validate()">
            Enter Product Name: <br/><input id="product_name" type="text" name="product_name" /> <br/>
            Enter Price: <br/><input id="price" type="text" name="price" /> <br/>
            Enter Type ID : <br/><input id="type_id" type="text" name="type_id" /> <br/>
            <br/>
            <input type="submit" value="Create" /><br/>
        </form>
         <br/>
        <a href="MDHome.jsp"><button type="button">Back</button></a><br/>
        <br/>
        
    <script>
            function validate() {
    if (document.getElementById("product_name").value==""|| document.getElementById("price").value==""||document.getElementById("type_id").value==""){
         alert("Enter All Fields");
         return false;
    } else {
        return true;
    }
}
 </script>
 
    </body>
</html>
