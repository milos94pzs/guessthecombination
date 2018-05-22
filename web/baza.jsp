<%-- 
    Document   : igra
    Created on : Feb 16, 2018, 8:58:42 PM
    Author     : ickarus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        <title>Baza</title>
    </head>
    <body>
        
    <center>
        
        <h3>Sve informacije o igracima</h3>
        
        <table border="1">
            
            <tr>
            <th>username</th>
            <td>password</td>
            <td>ime</td>
            <td>prezime</td>
            <td>poeni</td>
            <td>opis korisnika</td>
            </tr>
        
        <c:forEach items="${korisnici}" var="k">
        
            <tr>
            <th>${k.username}</th>
            <td>${k.password}</td>
            <td>${k.ime}</td>
            <td>${k.prezime}</td>
            <td>${k.poeni}</td>
            <td>${k.opis}</td>
            </tr>
             </c:forEach>
        </table>
        
        <h3>Sve informacije o komisiji</h3>
        
        <table border="1">
            
            <tr>
            <th>username</th>
            <td>password</td>
            <td>ime</td>
            <td>prezime</td>
            <td>opis korisnika</td>
            </tr>
        
            <c:forEach items="${adminIKomisija}" var="k" begin="1" end="2">
        
            <tr>
            <th>${k.username}</th>
            <td>${k.password}</td>
            <td>${k.ime}</td>
            <td>${k.prezime}</td>
            <td>${k.opis}</td>
            </tr>
             </c:forEach>
        </table>
        <br><br>
        <a href="igra.jsp" class="linkDugme">Nazad</a>
        
    </center>
    
    
    
    </body>
</html>
