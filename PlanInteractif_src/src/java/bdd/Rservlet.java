/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 *
 * @author MACYLIA
 */
@WebServlet(name = "Rservlet", urlPatterns = {"/Rservlet"})
public class Rservlet extends HttpServlet {

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
        String recherche = request.getParameter("choixRecherche");
         out.println( recherche );
         
         if("cote".equals(recherche)){
         RequestDispatcher rd = request. getRequestDispatcher ("Rcote.jsp");
                            rd.forward(request, response);
}
          if("dicsipline".equals(recherche)){
         RequestDispatcher rd = request. getRequestDispatcher ("Rdiscipline.jsp");
                             rd.forward(request, response);
}
         if("sous_dicsipline".equals(recherche)){
         RequestDispatcher rd = request. getRequestDispatcher ("Rsous_discipline.jsp");
                            rd.forward(request, response);
}

                out.println( "</body></html>" );


    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
