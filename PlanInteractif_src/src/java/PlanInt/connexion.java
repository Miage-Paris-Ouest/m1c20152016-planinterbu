/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanInt;

/**
 *
 * @author ibs
 */
import java.sql.*; // Étape 0
public class connexion {
    
    /*
public static void main( String[] args ) {

    Ouvrage livre= new Ouvrage();
    System.out.println("Recherche par cote ");
    livre.rechercheparcote("111");
    System.out.println("Recherche par discipline ");
    livre.RechercheParDiscipline("Philosophie");
    System.out.println("Recherche par sous discipline ");
    livre.RechercheParSsDiscipline("Ontologie ");
   
    String url=" ";
           url = livre.affichEtagere("111", url);
           
           System.out.println(url);
    /*
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch( Exception ex ) {
System.err.println( "Erreur lors du chargement du driver" );
System.exit(1);
}
try {

String url ="jdbc:oracle:thin:@//localhost:1521/xe";
Connection cx =
DriverManager.getConnection (url, "SYSTEM", "SYS");

Statement st = cx.createStatement();
ResultSet rs = st.executeQuery( "SELECT  * FROM contenu_bu" );

/
int etagere;
while (rs.next()) {
    
String etagerenontraite = rs.getString("etagere");
if ( etagerenontraite.length() == 2)
     etagere= Integer.parseInt(etagerenontraite);

   String salle = rs.getString("salle");
   //int etagere= Integer.parseInt (rs.getString("etagere"));
   String discipline = rs.getString("discipline");
   String ssdiscipline = rs.getString("ssdiscipline");
   int cote= Integer.parseInt (rs.getString("cote"));
System.out.println(salle+ " "+etagere+" "+discipline+" "+ssdiscipline+" "+cote+" ");

//int age= rs.getInt("age");
//System.out.println(nom+" est agé de "+age);
}



rs.close();
st.close();
cx.close();
}
catch( SQLException ex ) {
System.err.println( "Erreur lors de la cx à la base" );
System.exit(1);
}
}

}*/
}