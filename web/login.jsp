<%-- 
    Document   : login
    Created on : Mar 17, 2014, 7:00:58 PM
    Author     : Ksiezniczka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form action="j_security_check" method=post>
    <p><strong>Please Enter Name: </strong>
    <input type="text" name="j_username" size="25">
    <p><p><strong>Please Enter Password: </strong>
    <input type="password" size="15" name="j_password">
    <p><p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
    </body>
</html>
