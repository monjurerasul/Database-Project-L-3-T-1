<%-- 
    Document   : CreateNewAccount
    Created on : 12-Dec-2016, 16:07:30
    Author     : Hasan Murad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New MPO Account</title>
    </head>
    <body>
         <form method="post" action="AddNewMpo.do" onsubmit="return validate()">
            Enter First Name: <br/><input id="first_name" type="text" name="first_name" /> <br/>
            Enter Last Name : <br/><input id="last_name" type="text" name="last_name" /> <br/>
            Enter Password: <br/><input id="password" type="password" name="password" /> <br/>
            Enter Salary : <br/><input id="salary" type="text" name="salary" /> <br/>
            <br/>
            <input type="submit" value="Create" />
        </form>
        
        <br/>
        <a href="DepoManagerHome.jsp"><button type="button">Back</button></a><br/>
        <br/>
        
     <script>
            function validate() {
    if (document.getElementById("first_name").value == "" || document.getElementById("last_name").value==""||document.getElementById("password").value==""||document.getElementById("salary").value=="" ){
         alert("Enter All Fields");
         return false;
    } else {
        return true;
    }
}
 </script>    
    </body>
</html>
