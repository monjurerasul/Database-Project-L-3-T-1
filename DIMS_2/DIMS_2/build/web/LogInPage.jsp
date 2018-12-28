<%-- 
    Document   : LogInPage
    Created on : 12-Dec-2016, 17:04:06
    Author     : Hasan Murad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
       <%
            String loginflag=(String)session.getAttribute("loginflag");
            if(loginflag=="No")out.println("Wrong User ID or Password");
        %>
        <br/>
        <form method="post" action="LoginProcessServlet.do" onsubmit="return validate()">
            Enter your User ID: <br/><input id="user_id"type="text" name="userid" /> <br/>
            Enter your Password: <br/><input id = "password" type="password" name="password" /> <br/><br/>
            <input type="submit" value="Log" /><br/><br/>
        </form>
        <a href="HomePage.html"><button type="button">Back</button></a><br/>
        
        <script>
            function validate() {
    if (document.getElementById("user_id").value == "" || document.getElementById("password").value == "") {
         alert("user_id or password fields are empty");
         return false;
    } else {
        return true;
    }
}
         </script>
    </body>
</html>
