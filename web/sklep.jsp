<%--
    Document   : sklep
    Created on : Oct 29, 2013, 1:49:49 PM
    Author     : Ksiezniczka
--%>
<%@page import="model.produkt.Database"%>
<%@page import="model.produkt.Produkt" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
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
             
           <c:forEach items="${ListaProduktow}" var="towar">
           <tr>
                    <td>${towar.getProductID()}</td>
                    <td>${towar.getName()}</td>
                    <td>${towar.getPrice()}</td>
                    
                    
           <c:url value="/koszyk" var="URL">
           <c:param name="produktID" value="${towar.getProductID()}"/> 
           <c:param name="action" value="add"/>
           </c:url>
                    <td><a href="<c:out value="${URL}"/>">
                    <c:set var="przycisk" value="Dodaj"/><c:out value="${przycisk}"/></a> 
                    </td>
            </tr>
           
           </c:forEach>
        
            </table>
          <br>
        <c:url value="/admin" var="URL">
            <c:param name="action" value="goToPanel"/>
        </c:url>
         
        <a href="<c:out value="${URL}"/>">
            <c:set var="przycisk" value="Panel admin"/><c:out value="${przycisk}"/></a> 
        </center>
    </body>
</html>