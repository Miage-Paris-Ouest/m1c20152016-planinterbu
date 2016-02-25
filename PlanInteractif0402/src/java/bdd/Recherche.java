/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import PlanInt.Ouvrage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MACYLIA
 */
@WebServlet(name = "Recherche", urlPatterns = {"/Recherche"})
public class Recherche extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
           out.println( "<html><body>" );
           out.println( "<h1>Hello depuis une servlet</h1>" );
           
           Ouvrage ouvrage = new Ouvrage();
           
        String rechercheCote = request.getParameter("scote");
         //out.println( rechercheCote );
         //ouvrage.rechercheparcote(rechercheCote);
         Ouvrage livre2 = new Ouvrage();
         Ouvrage livre1 = new Ouvrage();
         Ouvrage livre3 = new Ouvrage();
         
          if ((rechercheCote) != null)
          {
              String etg=" ";
        etg= livre3.affichEtagere(rechercheCote,etg);

       
         out.println("<img src="+etg+" />");
         
          }
        
        
         String rechercheDiscipline = request.getParameter("sdiscipline");
         if ((rechercheDiscipline ) != null)
                 {
         out.println( rechercheDiscipline );
         String dis=" ";
         dis= livre1.affichDiscipline(rechercheDiscipline, dis);
         out.println(dis);


       
       
         out.println("<img src=\""+dis+"\"/>");
                 }
         
         //ouvrage.RechercheParDiscipline(rechercheDiscipline);
         
          String rechercheSousDiscipline = request.getParameter("ssousDiscipline");
          if ((rechercheSousDiscipline) != null)
          {
               out.println( rechercheSousDiscipline );
         String ssdis=" ";
        ssdis= livre2.affichSsDiscipline("Géographie universelle ", ssdis);
         out.println("<img src=\""+ssdis+"\"/>");
         //out.println(ssdis);
          }
        
          //ouvrage.RechercheParSsDiscipline(rechercheSousDiscipline);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
