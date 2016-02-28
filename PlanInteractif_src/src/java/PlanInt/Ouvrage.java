/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanInt;
import java.sql.*; // Étape 0

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ibs
 */
public class Ouvrage {
    
String cote;
String etagere;
String discipline;
String ssDiscipline;
String salle;

public Ouvrage()
{
    
}
public Ouvrage(String cote, String discipline, String ssDiscipline, String etagere, String salle)
{
    this.cote=cote;
    this.etagere=etagere;
    this.discipline=discipline;
    this.ssDiscipline =ssDiscipline;
    this.salle=salle;
    
    
    
}

public String rechercheparcote(String coteSaisie)
{

String result="";
/** Chargement du driver JDBC - Étape 1 */
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch( Exception ex ) {
System.err.println( "Erreur lors du chargement du driver" );
System.exit(1);
}
try {
/** Connection à la base - Étape 2 */
//String url="jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE";
String url ="jdbc:oracle:thin:@//localhost:1521/xe";
Connection cx =
DriverManager.getConnection (url, "SYSTEM", "SYS");
/** Création et exécution d'une requête - Étapes 3 & 4 */
Statement st = cx.createStatement();
ResultSet rs = st.executeQuery( "SELECT  * FROM contenu_bu" );

/** Affichage du résultat - Étape 5 */
int etagere;

while (rs.next()) {
String cote= rs.getString("cote");
//System.out.println(cote);
if ( cote.equals(coteSaisie))
     
{

   String salle = rs.getString("salle");
   //int etagere= Integer.parseInt (rs.getString("etagere"));
   String discipline = rs.getString("discipline");
   String ssdiscipline = rs.getString("ssdiscipline");
   String etagerenontraite = rs.getString("etagere");
result=("Résultats pour la cote: "+cote+"    -Salle : "+salle +"    -Discipline : "+discipline+"     -Sous discipline : "+ssdiscipline+"    -Numéro étagère :"+etagerenontraite);

//int age= rs.getInt("age");
//System.out.println(nom+" est agé de "+age);
}


    
}

/** Fermetures - Étape 6 */
rs.close();
st.close();
cx.close();
}
catch( SQLException ex ) {
System.err.println( "Erreur lors de la cx à la base" );
System.exit(1);
}
return result;
}

public String RechercheParDiscipline(String disc)
{
   String result=" ";
    try {
Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch( Exception ex ) {
System.err.println( "Erreur lors du chargement du driver" );
System.exit(1);
}
try {
/** Connection à la base - Étape 2 */
//String url="jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE";
String url ="jdbc:oracle:thin:@//localhost:1521/xe";
Connection cx =
DriverManager.getConnection (url, "SYSTEM", "SYS");
/** Création et exécution d'une requête - Étapes 3 & 4 */
Statement st = cx.createStatement();
ResultSet rs = st.executeQuery( "SELECT  * FROM contenu_bu" );

/** Affichage du résultat - Étape 5 */


while (rs.next()) {
String discipline = rs.getString("discipline");
//System.out.println(cote);
if ( discipline.equals(disc))
     
{

   String salle = rs.getString("salle");
   //int etagere= Integer.parseInt (rs.getString("etagere"));
   
   String cote= rs.getString("cote");
   String ssdiscipline = rs.getString("ssdiscipline");
   String etagerenontraite = rs.getString("etagere");
result=("Résultats pour la discipline : "+disc+"    -Salle : "+salle +"     -Sous discipline : "+ssdiscipline+"    -Numéro étagère :"+etagerenontraite+"       -Racine de cote : "+cote);

}    
}

/** Fermetures - Étape 6 */
rs.close();
st.close();
cx.close();
}
catch( SQLException ex ) {
System.err.println( "Erreur lors de la cx à la base" );
System.exit(1);
}
return result;
}

public String RechercheParSsDiscipline(String ssDisc)
        
{
/** Chargement du driver JDBC - Étape 1 */
String result=" ";
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
/** Création et exécution d'une requête - Étapes 3 & 4 */
Statement st = cx.createStatement();
ResultSet rs = st.executeQuery( "SELECT  * FROM contenu_bu" );

/** Affichage du résultat - Étape 5 */


while (rs.next()) {
String ssdiscipline = rs.getString("ssdiscipline");
//System.out.println(cote);
if ( ssdiscipline.equals(ssDisc))
     
{

   String salle = rs.getString("salle");
   //int etagere= Integer.parseInt (rs.getString("etagere"));
   
   String cote= rs.getString("cote");
   String discipline = rs.getString("discipline");
   String etagerenontraite = rs.getString("etagere");
   
result=("Résultats pour la sous discipline : "+ssDisc+"    -Salle : "+salle +"     - Discipline : "+discipline+"    -Numéro étagère :"+etagerenontraite+"       -Racine de cote : "+cote);

}


    
}

/** Fermetures - Étape 6 */
rs.close();
st.close();
cx.close();
}
catch( SQLException ex ) {
System.err.println( "Erreur lors de la cx à la base" );
System.exit(1);
}
return result;
}


    public String affichEtagere(String coteSaisie, String urlLue)
        
{
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
ResultSet rs = st.executeQuery( "SELECT  * FROM Etagere " );

while (rs.next()) {
String cotelue = rs.getString("cote");
if ( cotelue.equals(coteSaisie))
     
{
   urlLue = rs.getString("url");
}

}

rs.close();
st.close();
cx.close();
}
catch( SQLException ex ) {
System.err.println( "Erreur lors de la cx à la base" );
System.exit(1);
}
return urlLue;
}

    
    
    /// plan discipline salle 
    
    public String affichDiscipline(String discSaisie, String urlLue)
        
{
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
ResultSet rs = st.executeQuery( "SELECT  * FROM discipline " );

while (rs.next()) {
String disciplinelue = rs.getString("discipline");
if ( disciplinelue.equals(discSaisie))
     
{
   urlLue = rs.getString("url");
}

}

rs.close();
st.close();
cx.close();
}
catch( SQLException ex ) {
System.err.println( "Erreur lors de la cx à la base" );
System.exit(1);
}
return urlLue;
}

    
    // plan ss discipline 
    
    public String affichSsDiscipline(String ssdiscSaisie, String urlLue)
        
{
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
ResultSet rs = st.executeQuery( "SELECT  * FROM ssdiscipline " );

while (rs.next()) {
String ssdisciplinelue = rs.getString("ssdiscipline");
if ( ssdisciplinelue.equals(ssdiscSaisie))
     
{
   urlLue = rs.getString("url");
}

}

rs.close();
st.close();
cx.close();
}
catch( SQLException ex ) {
System.err.println( "Erreur lors de la cx à la base" );
System.exit(1);
}
return urlLue;
}

}



  

