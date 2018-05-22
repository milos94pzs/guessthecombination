<%-- 
    Document   : igra
    Created on : Feb 16, 2018, 8:58:42 PM
    Author     : ickarus
--%>

<%@page import="model.Igra"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Korisnik"%>
<%@page import="servleti.kombinacijaServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        <title>Igra pogadjanja</title>
    </head>
    <body>
        
        
        <style>
            .obrisi{
                font-size: 16px;
            }
            
            
        </style>
        
        <h1>Igra pogadjanja</h1>
        <p>Dobrodosli korisnice <b>${ulogovani.username}</b></p>
        <p>vrsta korisnika : ${ulogovani.opis}</p>
        <hr>
        
        <div>
            <h2 class="pravila">Pravila</h2>
            <ol>
                <li>Svaki korisnik ima pravo na samo jedno pogadjanje, unesite brojeve u 4 polja</li>
                <li>Treba da pogodite tacnu kombinaciju kako biste dobili maksimalan broj bodova.</li>
                <li>Ako korisnik unese broj na dobrom mestu dobija 1 poen,a ako
        pogodi broj u nizu onda jos 1 poen.</li>
                <li>Ako broj koji je pogođen je na istom mestu kao i u zadatoj kombinaciji : 2poena</li>
                <li>Ako je broj pogođen ali nije na dobrom mestu onda korisnik dobija 1 poen.</li>
            </ol>
            
            
            <%      //ispis kombinacije
                
                    String k1 = Igra.getKombinacija1();
                    String k2 = Igra.getKombinacija2();
                    String k3 = Igra.getKombinacija3();
                    String k4 = Igra.getKombinacija4();
                    
                    String ispis = k1 + " " + k2 + " " + k3 + " " +k4;
                %>
                
                
                
        <hr>
        </div>
                
                
        
        <h3>Admin i clanovi komisije</h3>
        
        <center>
        <table border="1">
            <tr>
                <th>ime korisnika</th>
                <td>opis korisnika</td>
            </tr>
            <c:forEach items="${adminIKomisija}" var="a">
            <tr>
                
                <td>${a.username}</td>
                <td>${a.opis}</td>
            </tr>
            </c:forEach>
            </table>
            
            
             <!-- stranica za administratore -->
            
            <c:if test="${ulogovani.opis eq 'admin'}">
                
                
            
            <h3>Rang lista igraca</h3>
            
            <table border="1">
            
            <tr>
                <td>pozicija</td>
                <th>ime korisnika</th>
                <td>broj poena</td>
                <td>kombinacija</td>
                <td>preostalih pokusaja</td>
                <td>opis korisnika</td>
                <td>brisanje korisnika</td>
            </tr>
            
            <c:forEach items="${korisnici}" var="k">
                
               
                
           <tr>
                <td class="brojac">.</td>
                <td>${k.username}</td>
                <td>${k.poeni}</td>
                <td>${k.kombinacija}</td>
                <td>${k.pokusaji}</td>
                <td>${k.opis}</td>
                <td><a href="brisanjeKorisnikaServlet?nazivUsername=${k.username}" class="obrisi">obrisi</a></td>
            </tr>
            </c:forEach>
        </table>
            
            
                
                
            <br>
            <form action="restartRundeServlet" method="post">
                    <input type="submit" value="Restart runde" id="restart">
            </form>
            <br>
            <a href="baza.jsp" class="linkDugme">Pristup bazi</a>
        </center>
            
            Kombinacija je <%=ispis%>
                <br><br>
                <a href="izmenaKombinacije.jsp" class="linkDugme">Izmeni kombinaciju</a>
            
            <br>
            <center>
            <a href="login.html" class="linkDugme">Nazad na login stranicu</a>
            <br><br>
            <a href="index.html" class="linkDugme">Nazad na index stranicu</a>
            </center>
            
            </c:if>
        <br>
        
        
           
        
                
                
                <!--stranica za komisiju-->
                
                
                
            
                <c:if test="${ulogovani.opis eq 'komisija'}">
                    <center>
                    
                    <h3>Rang lista igraca</h3>
                    
                    <table border="1">
                <tr>
                <td>pozicija</td>
                <th>ime korisnika</th>
                <td>broj poena</td>
                <td>kombinacija</td>
                <td>preostalih pokusaja</td>
                <td>opis korisnika</td>
            </tr>
            
            <c:forEach items="${korisnici}" var="k">
                
               
            <tr>
                <td class="brojac">.</td>
                <td>${k.username}</td>
                <td>${k.poeni}</td>
                <td>${k.kombinacija}</td>
                <td>${k.pokusaji}</td>
                
                <td>${k.opis}</td>
                
            </tr>
            </c:forEach>
        </table>
                        
            <br>
                        
                        
            <form action="restartRundeServlet" method="post">
                    <input type="submit" value="Restart runde" id="restart">
            </form>
            
            <br>
            
            
            
        </center>
                    <p>Kombinacija je <%=ispis%> <br></p>
            
            <br>
            <center>
            <a href="login.html" class="linkDugme">Nazad na login stranicu</a>
            <br><br>
            <a href="index.html" class="linkDugme">Nazad na index stranicu</a>
                    
                   
                    
                </c:if>
        
        
        
            <!--stranica za obicne korisnike-->
            
            
            
            <c:if test="${ulogovani.opis eq 'igrac'}">
                <center>
                    <h3>Rang lista igraca</h3>
                    
        <table border="1">
                <tr>
                <td>pozicija</td>
                <th>ime korisnika</th>
                <td>broj poena</td>
                <td>preostalih pokusaja</td>
                <td>opis korisnika</td>
            </tr>
            
            <c:forEach items="${korisnici}" var="k">
                
               
            <tr>
                <td class="brojac">.</td>
                <td>${k.username}</td>
                <td>${k.poeni}</td>
                <td>${k.pokusaji}</td>
                <td>${k.opis}</td>
                
            </tr>
            </c:forEach>
        </table>
                    
                    <c:if test="${ulogovani.pokusaji != 0}">
                    
                    <h3>Vasa kombinacija?</h3>
            <form action="kombinacijaServlet" method="post" id="kombinacija">
                <input type="text" name="kombinacija1" maxlength="1" size="1"/>
                <input type="text" name="kombinacija2" maxlength="1" size="1"/>
                <input type="text" name="kombinacija3" maxlength="1" size="1"/>
                <input type="text" name="kombinacija4" maxlength="1" size="1"/>
                <br><br>
                <input type="submit" value="Potvrdi kombinaciju" id="potvrdiKomb"/>
            </form>
                    
                    </c:if>
                </center>
                
                
                <br>
            <center>
            <a href="login.html" class="linkDugme">Nazad na login stranicu</a>
            <br><br>
            <a href="index.html" class="linkDugme">Nazad na index stranicu</a>
            </center>
                
                
                
                
                </c:if>
            
                
                
                
                
                
                
                
                
                
                   
    </body>
</html>
