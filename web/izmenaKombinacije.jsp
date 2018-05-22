<%-- 
    Document   : izmenaKombinacije
    Created on : Feb 22, 2018, 8:30:17 PM
    Author     : ickarus
--%>

<%@page import="model.Igra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" type="text/css" rel="stylesheet">
        <title>Izmena kombinacije</title>
    </head>
    <body>
        <%      //ispis kombinacije
                
                    String k1 = Igra.getKombinacija1();
                    String k2 = Igra.getKombinacija2();
                    String k3 = Igra.getKombinacija3();
                    String k4 = Igra.getKombinacija4();
                    
                    String ispis = k1 + " " + k2 + " " + k3 + " " +k4;
                %>
                <div class="okvir_div">
                <p>Trenutna kombinacija je <%=ispis%></p>
                <br>
                Izmena :<br><br>
                <form action="izmenaKombinacijeServlet" method="post">
                    
                    <table border='1'>
                        <tr>
                            <td>
                                prvi broj
                            </td>
                            <td>
                                drugi broj
                            </td>
                            <td>
                                treci broj
                            </td>
                            <td>
                                cetvrti broj
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" name="k1nova" maxlength="1" size="1"/>
                            </td>
                            <td>
                                <input type="text" name="k2nova" maxlength="1" size="1"/>
                            </td>
                            <td>
                                <input type="text" name="k3nova" maxlength="1" size="1"/>
                            </td>
                            <td>
                                <input type="text" name="k4nova" maxlength="1" size="1"/>
                            </td>
                        </tr>
                    </table>
                    
                    <br>
                    
                    <input type="submit" value="Potvrdi kombinaciju" id="potvrdi"/>

                </form>
                
                <br><br>
                <a href="igra.jsp" class="linkDugme">Nazad</a>
                
                </div>
    </body>
</html>
