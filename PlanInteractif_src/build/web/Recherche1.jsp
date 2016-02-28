<%-- 
    Document   : Recherche1
    Created on : 4 févr. 2016, 12:08:33
    Author     : ibs
--%>
<%--
<%@page import="PlanInt.Ouvrage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Bienvenue sur Plan interactif BU </h1>
        <h2> Université Paris Ouest Nanterre La Défense </h2>
        <p>
            <%
                
                Ouvrage livre= new Ouvrage();
                Ouvrage livre1= new Ouvrage();
                Ouvrage livre2= new Ouvrage();
   
   
    String u=" ";
           u= livre.affichEtagere("111", u);
           
String d=" ";
d= livre1.affichDiscipline("Philosophie", d);

String ssdis=" ";
ssdis= livre2.affichSsDiscipline("Géographie universelle ", ssdis);
%>
     <br />
     <img src="<%=u %>"alt="cccc2"  heighth="1000" width ="500"  />
     <img src="<%=d %>"alt="cccc2"  heighth="1000" width ="1000"  />
     <img src="<%=ssdis %>"alt="cccc2"  heighth="1000" width ="1000"  />
</p>
    </body>
</html>
--%>