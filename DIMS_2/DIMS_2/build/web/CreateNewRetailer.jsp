<%-- 
    Document   : CreateNewRetailer
    Created on : 15-Dec-2016, 00:30:04
    Author     : MONJUR-E-RASUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Retailer</title>
    </head>
    <body>
         <form method="post" action="AddNewRetailer.do" onsubmit="return validate()">
            Enter Name : <br/><input id="retailer_name" type="text" name="retailer_name" /> <br/>
            Enter Address: <br/><input id="address" type="text" name="address" /> <br/>
            
            <br/>
            <input type="submit" value="Create" />
        </form>
        
        <br/>
        <a href="MpoHome.jsp"><button type="button">Back</button></a><br/>
        <br/>
        
     <script>
            function validate() {
    if (document.getElementById("retailer_name").value==""||document.getElementById("address").value=="" ){
         alert("Enter All Fields");
         return false;
    } else {
        return true;
    }
}
 </script>    
    </body>
</html>
