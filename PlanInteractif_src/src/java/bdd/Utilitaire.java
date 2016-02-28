/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;
  import java.sql.*;
/**
 *
 * @author MACYLIA
 */
public class Utilitaire {
   
    private static ResultSet rs;
    private static Statement st ;
     private static Connection conn;

     public Utilitaire(){}
     static{

          try{

           Class.forName("oracle.jdbc.driver.OracleDriver");
           }
          catch( Exception ex ) {
System.err.println( "Erreur lors du chargement du driver" );
System.exit(1);
}
try {
/** Connection à la base - Étape 2 */
String url ="jdbc:oracle:thin:@//localhost:1521/xe";
           conn=DriverManager.getConnection(url,"SYSTEM", "SYS");
             
                       st = conn.createStatement();
               rs = st.executeQuery( "SELECT * FROM contenu_bu" );
              
               
          }

          catch(Exception e){

                e.printStackTrace();

          }
    
     }  

 public static Connection getConnection(){

          return conn;

     }
 public static ResultSet getRs(){

          return rs;

     }
 
     
 public static void CloseConnection() throws SQLException{

          conn.close();   

     }
 public static void CloseResultSet () throws SQLException{

         rs.close();

     }
  
 public static void CloseStatement() throws SQLException{

          st.close();

     }
}
