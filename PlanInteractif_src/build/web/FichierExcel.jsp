<%-- 
    Document   : FichierExcel
    Created on : 21 févr. 2016, 18:26:47
    Author     : MACYLIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <%--    <jsp:useBean id="user" class=" bdd.User" scope="request"/>
         Bonjour monsieur  <%= user.getFirstName() %> <%= user.getLastName() %>   --%>
      <table class="ruban"> 
         <tr> <td> </td> </tr>
       </table> 
       <div align="center" > 
        <h1> Choisissez le fichier à télécharger : </h1>
         <table class="border" border="2"  width="400px" bgcolor="white" borderColor="darck"> 
        <form method=POST action=Rservlet >
       <tr> <td> <INPUT TYPE="file" accept=".ods" name="excel" style="width:400px;height:30px" class="bouton1"> <br> </td> </tr>
       <tr> <td align="center">  <input type="submit" value="Load" name="submit" style="width:100px;height:30px" class="bouton1" >      </td> </tr> 
         </form>
         </table>
        </div>
    </body>
</html>
