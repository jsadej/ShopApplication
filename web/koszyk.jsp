<%-- 
    Document   : koszyk
    Created on : Feb 18, 2014, 3:13:55 PM
    Author     : Ksiezniczka
--%>
<%@page import="model.produkt.Database"%>
<%@page import="model.produkt.Produkt" %>
<%@page import="model.produkt.ShoppingCart" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
    <center>
        <h1>Koszyk</h1>
        <table border=1>
            <tr>
                <td>Id</td>
                <td>Nazwa</td>
                <td>Cena </td>
               
            </tr>
            <c:forEach items="${ListaKoszyk}" var="koszyk">

                <tr>
                    <td>${koszyk.getValue().getProductID()}</td>
                    <td>${koszyk.getValue().getName()}</td>
                    <td>${koszyk.getValue().getPrice()}</td>
                   

                    <c:url value="/koszyk" var="URL">
                        <c:param name="produktID" value="${koszyk.getValue().getProductID()}"/>
                        <c:param name="action" value="delete"/>
                    </c:url>
                    <td><a href="<c:out value="${URL}"/>">
                            <c:set var="przycisk" value="Usuń"/><c:out value="${przycisk}"/></a> 
                    </td>
                </tr>
            </c:forEach>
                
                
        </table>
        <br>  Do zapłaty: ${price}             
                
   <br>
        <c:url value="/shop" var="URL"></c:url>
        <a href="<c:out value="${URL}"/>">
            <c:set var="przycisk" value="Powrot do Sklepu"/><c:out value="${przycisk}"/></a> 
         
    </center>
</body>
</html>
