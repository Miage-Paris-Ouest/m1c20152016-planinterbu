<%-- 
    Document   : Rdiscipline
    Created on : 21 févr. 2016, 13:39:07
    Author     : MACYLIA
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <table class="ruban"> 
         <tr> <td> </td> </tr>
       </table> 
        <font face="Verdana" size="6"> <p align="center"> <b >  Selectionnez la sous-discipline de l'ouvrage désiré :  </b > </p>   </font>

        <FORM method="post" action="Recherche">
  <div align="center"> 
 <table  border='1px'  classe="tableau"> 
 <tr> <td width="150px"height="50px" cellpadding="0"  >
<SELECT  name="ssousDiscipline" size="1" >
    
  <OPTION value=""  > selectinner</OPTION >  
    
<jsp:useBean id="bean" class="bdd.Utilitaire" scope="request"/>

<% ResultSet rs = bean.getRs();
    while (rs.next()) {
    String nom = rs.getString("ssdiscipline");
                               
%>
<OPTION value="<%= nom  %>" ><%= nom  %></OPTION >
<%} %>

</SELECT>
</td> 
<td> 
<input type="submit" value="Valider" name="submit" style="width:150px;height:50px" class="bouton1" > 
</td> </tr>
 </table>
</div> 
</FORM>
</body>
</html>
