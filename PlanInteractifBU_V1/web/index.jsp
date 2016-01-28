<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<jsp:forward page="Welcome.do"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        <h1>Connexion</h1>
        
        <html:form action="login">
            
            
         
         <table border="1">

<tr>
<td align="right"> Utilisateur : </td>
<td align="left"> <html:text property="name" size="20" maxlength="20"/> </td>
</tr>
<tr> 
<td align="right"> Mot de Passe : </td> 
<td align="left"> <html:password property="motpass" size="20" maxlength="20"/> </td>
</tr> 
<tr>
<td align="right"> <html:submit property="submit" value="Login"/>
</td>

        </table>


   
   
   <html:errors />
</html:form>
    </body>
    
    
</html>