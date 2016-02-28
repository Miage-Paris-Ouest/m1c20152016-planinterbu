<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title> Accueil Bibliothèque </title>
        <link rel="stylesheet" href="style.css">
         <meta charset="UTF-8" >
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
   
    <body>
    
          <table class="ruban"> 
             <tr> <td> <font  face="Verdana" size="1" color="blue"> <a href="FichierExcel.jsp"> Modifer les données</a></td></tr>
         </table>    
      <p align="center"> <font face="Verdana" size="7">  <b >  <i >      Bienvenu au plan Interactif    </i > </b >  </font></p>
       
        <div align='center' id="form" class="bordure">
          <p align='center'> <font  face="Verdana" size="5"> Choisissez la methode de recherche :     </font> </p>
             <form  method=POST action=Rservlet>  
			  <p align="center"> 
            <table >   
         <tr><td ><font  face="Verdana" size="5"> Par Cote : </font><td><input type="radio" value="cote" name="choixRecherche" > </td> </tr>
         <tr><td><font  face="Verdana" size="5"> Par Dicsipline : </font><td><input type="radio" value="dicsipline" name="choixRecherche" >  </td></tr>
         <tr> <td> <font  face="Verdana" size="5"> Par Sous_Discipline : </font><td><input type="radio" value="sous_dicsipline" name="choixRecherche" > </td> </tr>
           
       
         <tr> <td colspan="2" height="200" align="center">  <input type="submit" value="Valider" name="submit" style="width:200px;height:50px" class="bouton" >  </td></tr> 
             </table>
		
         </form >  
        </div>
       
       
    </body>
</html>
