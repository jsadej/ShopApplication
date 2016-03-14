<%-- 
    Document   : formularz
    Created on : Mar 2, 2014, 2:34:24 PM
    Author     : Ksiezniczka
--%>
<%@page import="model.produkt.Database"%>
<%@page import="model.produkt.Produkt" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>

    <center>
        <h1> Sklep IT  </h1>

        <table border=1>
            <tr>
                <td>Id</td>
                <td>Nazwa</td>
                <td>Cena </td>
            </tr>

            <c:forEach items="${Lista}" var="towar">
                <tr>
                    <td>${towar.getProductID()}</td>
                    <td>${towar.getName()}</td>
                    <td>${towar.getPrice()}</td>

                    <c:url value="/admin" var="URL">
                        <c:param name="produktID" value="${towar.getProductID()}"/> 
                        <c:param name="nazwa" value="${towar.getName()}"/> 
                        <c:param name="cena" value="${towar.getPrice()}"/> 

                    </c:url> 
                    <td><a href="<c:out value="${URL}&action=edition"/>">Update

                        </a> 
                    </td>
                    <td><a href="<c:out value="${URL}&action=delete"/>">Delete
                        </a> 
                    </td>
                </tr> 
            </c:forEach>
        </table>

        <form method="post" action="/admin">
            <h4> Dodaj do bazy  </h4>
            <h6>
                <br> Nazwa<input type=text name="nazwa"  size=10 >      
                <br>cena<input type=text name="cena" size=10  >
               Zniżki<select name="Discounts">
                <c:forEach items="${DISCOUNT}" var="discount">
                <option   value="${discount.getdiscountPrice()}">${discount.getdiscountPrice()}
                </c:forEach>
                <option  value="BrakZnizki" selected="selected">Brak
            </select>
                <input type="hidden" name="akcja" value="dodaj"> 
                <br><input type="submit" value="Insert">
            </h6>
        </form> 
       </center>    
    </body>
    
</html>
