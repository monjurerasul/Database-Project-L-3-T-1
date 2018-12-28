<%-- 
    Document   : CreateNewJob
    Created on : 15-Dec-2016, 01:02:58
    Author     : MONJUR-E-RASUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Area</title>
    </head>
    <body>
         <form method="post" action="AddNewArea.do" onsubmit="return validate()">
            Enter Area Name: <br/><input id="area_name" type="text" name="area_name" /> <br/>
            <br/>
            <input type="submit" value="Create" />
        </form>
        
        <br/>
        <a href="MDHome.jsp"><button type="button">Back</button></a><br/>
        <br/>
        
     <script>
            function validate() {
    if ( document.getElementById("area_name").value=="" ){
         alert("Enter All Fields");
         return false;
    } else {
        return true;
    }
}
 </script>    
    </body>
</html>
