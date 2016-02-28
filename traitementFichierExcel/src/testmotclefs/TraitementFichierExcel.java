package testmotclefs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TraitementFichierExcel {

  public static void main(
      String[] args) {
      
      /* ------------------- CHARGEMENT DU DRIVER POUR LA BASE DE DONNEES -------------------- */
            /** Chargement du driver JDBC - Étape 1 */
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch( Exception ex ) {
            System.err.println( "Erreur lors du chargement du driver" );
            System.exit(1);
        
        }
        
      /* ----------------------------------------------------------------------- */

    try {
        /* *********************** LIBRAIRIE POI ************************ */
      POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("fichierDeBaseBis.xls"));
      Workbook wb = WorkbookFactory.create(fs);
      Sheet sheet = wb.getSheetAt(0);
      Row row = null;
      Row ligne = null;
      Cell salle = null;
      Cell etagere = null ;
      Cell discipline = null ;
      Cell sDiscipline = null ;
      Cell cote = null ;
  
      int totalLigne = 0;
      int totalCol = 0;
      char virgule = ',' ;
      int debut = 1 ;
      
      int i =0 ;
      int nbLigne = 0 ;
      
      nbLigne= sheet.getPhysicalNumberOfRows() ;
      //System.out.println("NB LIGNES : "+ nbLigne) ;
      
      String aux = " " ;
      int commencement = 0, debutPlage=0, finPlage=0 ;
      
      /* ------------ CONNEXION A LA BASE DE DONNEES --------------- */
      String url="jdbc:oracle:thin:@//localhost:1521/xe";
    
      try {
    // Etape 2 : connexion a la base de donnees
    Connection cx = DriverManager.getConnection (url, "SYSTEM", "paabdou9");  
        System.out.println("Connexion a la base de donnees reussie \n");
        
    // etape 3: creation d'une zone de description de requetes
       Statement req = cx.createStatement();
       //int insert = req.executeUpdate("insert into salle values("+monId+",'"+maSalle+"')") ;
       int indice = 1 ;
      for (i=1;i<nbLigne;i++){
            ligne = sheet.getRow(i);
            salle = ligne.getCell(0) ;
            etagere = ligne.getCell(1) ;
            discipline = ligne.getCell(2) ;
            sDiscipline = ligne.getCell(3) ;
            cote = ligne.getCell(4);
        
            // ON VERIFIE SI LA LONGUEUR DU CHAMP EST SUPERIEUR A 2 
            // SI C'est le cas, on sait que le champ contient plusieurs etageres, faudrait en prendre compte 
            //pendant l'insertion a la BDD
            if(etagere.getStringCellValue().length()>2){
                for(int j=0;j<=etagere.getStringCellValue().length()-2;j+=3){
           
                    int etage = Integer.parseInt(etagere.getStringCellValue().substring(j,j+2));
                 
                    // ON VERIFIE SI LA DERNIERE COLONNE CONTIENT LES MOTS CLEFS SAUF ET à
                    if(cote.getStringCellValue().contains("sauf") && cote.getStringCellValue().contains("à")){
          
                        // ********** RECUPERATION DU COMMENCEMENT ********
                        aux=Character.toString(cote.getStringCellValue().charAt(0));
                        int pos = 1 ;
                        while (cote.getStringCellValue().charAt(pos)!=' '){
                             aux = aux+cote.getStringCellValue().charAt(pos);
                             pos++ ;    
                        }
                        commencement = Integer.parseInt((aux)) ; // ON A LA VALEUR DU COMMENCEMENT DANS LA VARIABLE COMMENCEMENT
                         
          
                        // ********** RECUPERATION DU DEBUT DE PLAGE ********
                        pos=cote.getStringCellValue().indexOf('f');
                        pos+=2 ; // Pour se positionner sur la plage de nombre
                        aux=Character.toString(cote.getStringCellValue().charAt(pos));
                        pos++; 
                        while (cote.getStringCellValue().charAt(pos)!=' '){
                            aux = aux+cote.getStringCellValue().charAt(pos);
                            pos++ ; // Pour se placer sur le deuxieme chiffre du debut de la plage    
                        }
                        debutPlage = Integer.parseInt(aux) ;
                        
          
                        // ********** RECUPERATION DE LA FIN DE PLAGE ********
                        pos=cote.getStringCellValue().indexOf('à');
                         pos+=2 ; // Pour se positionner sur la plage de nombre 
                        aux="" ;
                        while (pos<cote.getStringCellValue().length()){
                            aux = aux+cote.getStringCellValue().charAt(pos);
                            pos++ ; // Pour se placer sur le deuxieme chiffre du debut de la plage    
                        }
                        finPlage = Integer.parseInt(aux) ;
                        
          
                        int chiffreCentaine=0 ;
                        int auxCommencement = commencement*10 ;
                        if(auxCommencement == debutPlage){
                            for(int k=debutPlage;k<=finPlage;k++){
                                auxCommencement++;
                            }
                            for(int diz=(auxCommencement%10);diz<=9;diz++){
                                //indice+=1 ;
                                commencement = (commencement*10)+diz;
                                System.out.println(salle.getStringCellValue()+" | "+etage+" | "+discipline.getStringCellValue()+" | "+sDiscipline.getStringCellValue()+" | "+commencement);
                                
                                
                                // insere etage et commencement
                                //int insert = req.executeUpdate("insert into salle values("+monId+",'"+maSalle+"')") ;
                                /*System.out.println("Avant ici");
                                int i1 = req.executeUpdate("insert into salle (idSalle,titre) values("+indice+",'"+salle.getStringCellValue()+"')");
                                System.out.println("ici") ;
                               
                       
                                int i2 = req.executeUpdate("insert into discipline (idDiscipline,nomDiscipline,idSalle) values("+(indice++)+",'"+discipline.getStringCellValue()+"',"+indice+")");
                                System.out.println("ici2") ;
                                
                              
                                int i3 = req.executeUpdate("insert into sousdiscipline (idSD,idDiscipline,nom) values("+(indice+2)+","+(indice+1)+"',"+sDiscipline.getStringCellValue()+"')");
                                System.out.println("ici3") ;
                                int i4 = req.executeUpdate("insert into etagere (idEtagere,idSalle,numero) values("+(indice+3)+","+indice+","+etage+")");
                                System.out.println("ici4") ;
                                int i5 = req.executeUpdate("insert into cote (idCote,idDiscipline,racine) values("+(indice+4)+","+(indice+2)+","+commencement+")");
                                System.out.println("ici5") ;*/
                                if(commencement>=10 && commencement<=99){
                                    commencement=Integer.parseInt(Character.toString(cote.getStringCellValue().charAt(0))); // On redonne commencement sa valeur initiale
                                }
                                if(commencement>=100 && commencement<=999){
                                    commencement=Integer.parseInt(Character.toString(cote.getStringCellValue().charAt(0)))*10; // On redonne commencement sa valeur initiale
                                }
                                
                            }
                        }
                        else{
                            for(int m = auxCommencement;m<debutPlage;m++){
                                System.out.println(salle.getStringCellValue()+" | "+etage+" | "+discipline.getStringCellValue()+" | "+sDiscipline.getStringCellValue()+" | "+m);
                                /*
                                
                                // On insere etage et m
                                int i1 = req.executeUpdate("insert into salle (idSalle,titre) values("+indice+",'"+salle.getStringCellValue()+"')");
                                
                                int i2 = req.executeUpdate("insert into discipline (idDiscipline,nomDiscipline,idSalle) values("+indice+",'"+discipline.getStringCellValue()+"',"+indice+")");
                                
                                int i3 = req.executeUpdate("insert into sousdiscipline (idSD,idDiscipline,nom) values("+indice+","+indice+",'"+sDiscipline.getStringCellValue()+"')");
                                
                                int i4 = req.executeUpdate("insert into etagere (idEtagere,idSalle,numero) values("+indice+","+indice+","+etage+")");
                                
                                int i5 = req.executeUpdate("insert into cote (idCote,idDiscipline,racine) values("+indice+","+indice+","+m+")");
                  
                                indice++;*/
                            }
                            if(finPlage%10!=9){ // On verifie si la fin de plage ne finit pas par 9
                                for(int n = (finPlage%10)+1;n<=9;n++){
                                    int nAux = auxCommencement + n ;
                                    System.out.println(etage+" | "+salle.getStringCellValue()+" | "+discipline.getStringCellValue()+" | "+sDiscipline.getStringCellValue()+" | "+nAux);
                                    // On insere etage et nAux
                                    /*int i1 = req.executeUpdate("insert into salle (idSalle,titre) values("+indice+",'"+salle.getStringCellValue()+"')");
                                    
                                    int i2 = req.executeUpdate("insert into discipline (idDiscipline,nomDiscipline,idSalle) values("+indice+",'"+discipline.getStringCellValue()+"',"+indice+")");
                                    
                                    int i3 = req.executeUpdate("insert into sousdiscipline (idSD,idDiscipline,nom) values("+indice+","+indice+",'"+sDiscipline.getStringCellValue()+"')");
                                    
                                    int i4 = req.executeUpdate("insert into etagere (idEtagere,idSalle,numero) values("+indice+","+indice+","+etage+")");
                                    
                                   int i5 = req.executeUpdate("insert into cote (idCote,idDiscipline,racine) values("+indice+","+indice+","+nAux+")");*/
                           
                                }
                                //indice++;
                            }
                        }
            }
            else{
                 System.out.println(etage+" | "+salle.getStringCellValue()+discipline.getStringCellValue()+" | "+sDiscipline.getStringCellValue()+" | "+cote.getStringCellValue());
                 //insere etage et Integer.parseInt(cote.getStringValue()) ;
                 /*int i1 = req.executeUpdate("insert into salle (idSalle,titre) values("+indice+",'"+salle.getStringCellValue()+"')");
                 
                 int i2 = req.executeUpdate("insert into discipline (idDiscipline,nomDiscipline,idSalle) values("+indice+",'"+discipline.getStringCellValue()+"',"+indice+")");
                 
                 int i3 = req.executeUpdate("insert into sousdiscipline (idSD,idDiscipline,nom) values("+indice+","+indice+",'"+sDiscipline.getStringCellValue()+"')");
                 
                 int i4 = req.executeUpdate("insert into etagere (idEtagere,idSalle,numero) values("+indice+","+indice+","+etage+")");
                 
                 int i5 = req.executeUpdate("insert into cote (idCote,idDiscipline,raciine) values("+indice+","+indice+","+Integer.parseInt(cote.getStringCellValue())+")");
                   
                                indice++ ;*/
            }

                 // ...................................................................
                 
                 //System.out.print(etage+" ");  
           //indice++;
         }
         System.out.print("\n");
     }
     else{
                                 // ON VERIFIE SI LA DERNIERE COLONNE CONTIENT LES MOTS CLEFS SAUF ET à
                 if(cote.getStringCellValue().contains("sauf") && cote.getStringCellValue().contains("à")){
          
                        // ********** RECUPERATION DU COMMENCEMENT ********
                        aux=Character.toString(cote.getStringCellValue().charAt(0));
                        int pos = 1 ;
                        while (cote.getStringCellValue().charAt(pos)!=' '){
                             aux = aux+cote.getStringCellValue().charAt(pos);
                             pos++ ;    
                        }
                        commencement = Integer.parseInt((aux)) ; // ON A LA VALEUR DU COMMENCEMENT DANS LA VARIABLE COMMENCEMENT
                         
          
                        // ********** RECUPERATION DU DEBUT DE PLAGE ********
                        pos=cote.getStringCellValue().indexOf('f');
                        pos+=2 ; // Pour se positionner sur la plage de nombre
                        aux=Character.toString(cote.getStringCellValue().charAt(pos));
                        pos++; 
                        while (cote.getStringCellValue().charAt(pos)!=' '){
                            aux = aux+cote.getStringCellValue().charAt(pos);
                            pos++ ; // Pour se placer sur le deuxieme chiffre du debut de la plage    
                        }
                        debutPlage = Integer.parseInt(aux) ;
                        
          
                        // ********** RECUPERATION DE LA FIN DE PLAGE ********
                        pos=cote.getStringCellValue().indexOf('à');
                         pos+=2 ; // Pour se positionner sur la plage de nombre
                        //aux=Character.toString(chaine.charAt(pos));
                        //pos++; 
                        aux="" ;
                        while (pos<cote.getStringCellValue().length()){
                            aux = aux+cote.getStringCellValue().charAt(pos);
                            pos++ ; // Pour se placer sur le deuxieme chiffre du debut de la plage    
                        }
                        finPlage = Integer.parseInt(aux) ;
                        
          
                        int chiffreCentaine=0 ;
                        int auxCommencement = commencement*10 ;
                        if(auxCommencement == debutPlage){
                            for(int k=debutPlage;k<=finPlage;k++){
                                auxCommencement++;
                            }
                            for(int diz=(auxCommencement%10);diz<=9;diz++){
                                commencement = (commencement*10)+diz;
                                System.out.println(salle.getStringCellValue()+" | "+etagere.getStringCellValue()+" | "+discipline.getStringCellValue()+" | "+sDiscipline.getStringCellValue()+" | "+commencement);
                                // insere Integer.parseInt(etage.getStringValue()) et commencement
                               /*int i1 = req.executeUpdate("insert into salle (idSalle,titre) values("+indice+",'"+salle.getStringCellValue()+"')");
                                
                               int i2 = req.executeUpdate("insert into discipline (idDiscipline,nomDiscipline,idSalle) values("+indice+",'"+discipline.getStringCellValue()+"',"+indice+")");
                                
                                int i3 = req.executeUpdate("insert into sousdiscipline (idSD,idDiscipline,nom) values("+indice+","+indice+",'"+sDiscipline.getStringCellValue()+"')");
                                
                                int i4 = req.executeUpdate("insert into etagere (idEtagere,idSalle,numero) values("+indice+","+indice+","+Integer.parseInt(etagere.getStringCellValue())+")");
                                
                                 int i5 = req.executeUpdate("insert into cote (idCote,idDiscipline,racine) values("+indice+","+indice+","+commencement+")");*/
                                
                                commencement=Integer.parseInt(Character.toString(cote.getStringCellValue().charAt(0)));
                                //indice++;
                            }
                        }
            }
            else{
                 System.out.println(salle.getStringCellValue()+" | "+etagere.getStringCellValue()+" | "+discipline.getStringCellValue()+" | "+sDiscipline.getStringCellValue()+" | "+cote.getStringCellValue());
                 //insere Integer.parseInt(etage.getStringValue()) et Integer.parseInt(cote.getStringValue()) ;
                 /*int i1 = req.executeUpdate("insert into salle (idSalle,titre) values("+indice+",'"+salle.getStringCellValue()+"')");
                 
                 int i2 = req.executeUpdate("insert into discipline (idDiscipline,nomDiscipline,idSalle) values("+indice+",'"+discipline.getStringCellValue()+"',"+indice+")");
                 
                 int i3 = req.executeUpdate("insert into sousdiscipline (idSD,idDiscipline,nom) values("+indice+","+indice+",'"+sDiscipline.getStringCellValue()+"')");
                 
                  int i4 = req.executeUpdate("insert into etagere (idEtagere,idSalle,numero) values("+indice+","+indice+","+Integer.parseInt(etagere.getStringCellValue())+")");
                 
                  int i5 = req.executeUpdate("insert into cote (idCote,idDiscipline,racine) values("+indice+","+indice+","+Integer.parseInt(cote.getStringCellValue())+")");
          
                                indice++;*/
            }
          //System.out.println(etagere.getRichStringCellValue()); // FAIRE INSERTION DE LA VALEUR CONVERTI EN INT
     }
   }
        /* Fermeture des espaces ouverts */
      req.close();
      //pst.close();
      cx.close();
    }
    catch( SQLException ex ) {
        System.err.println( "Erreur lors de la cx à la base" );
        System.exit(1);
    }
      
    


    } catch (IOException e) {
      e.printStackTrace();
    } 
    
    /*catch (IOException e) {
      e.printStackTrace();
    }*/
  }
}