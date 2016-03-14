<%-- 
    Document   : formularz
    Created on : Mar 2, 2014, 3:24:26 PM
    Author     : Ksiezniczka
--%>
<%@page import="model.produkt.Database"%>
<%@page import="model.produkt.Produkt" %>
<%@page import="model.produkt.ShoppingCart" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>

        <form method="post" action="/admin">
            <input type="hidden" name="produktID" value="${ID}">
            Nazwa<input type=text name="nazwa" size=20 value="${NAME}" ><br>        
            cena<input type=text name="cena" size=20 value="${PRICE}" ><br>
            Zniżki<select name="Discounts">
                <c:forEach items="${DISCOUNT}" var="discount">
                <option   value="${discount.getdiscountPrice()}">${discount.getdiscountPrice()}
                </c:forEach>
                <option  value="BrakZnizki" selected="selected">Brak
            </select>
            <br><input type="submit" >



        </form>

    </body>
</html>
