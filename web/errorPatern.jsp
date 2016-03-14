<%-- 
    Document   : errorPatern
    Created on : Mar 24, 2014, 4:22:49 PM
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
        <form method="post" action="/admin">
            Wpisałes złe dane! Ponów
            <h6>
                <br> Nazwa<input type=text name="nazwa"  size=10 >      
                <br>cena<input type=text name="cena" size=10  >
                <input type="hidden" name="akcja" value="dodaj"> 
                <br><input type="submit" value="Insert">
            </h6>
        </form>
    </body>
</html>
