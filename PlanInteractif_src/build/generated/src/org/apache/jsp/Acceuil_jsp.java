package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Acceuil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> Accueil Bibliothèque </title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("         <meta charset=\"UTF-8\" >\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("   \n");
      out.write("    <body>\n");
      out.write("    \n");
      out.write("          <table class=\"ruban\"> \n");
      out.write("             <tr> <td> <font  face=\"Verdana\" size=\"1\" color=\"blue\"> <a href=\"FichierExcel.jsp\"> Modifer les données</a></td></tr>\n");
      out.write("         </table>    \n");
      out.write("      <p align=\"center\"> <font face=\"Verdana\" size=\"7\">  <b >  <i >      Bienvenu au plan Interactif    </i > </b >  </font></p>\n");
      out.write("       \n");
      out.write("        <div align='center' id=\"form\" class=\"bordure\">\n");
      out.write("          <p align='center'> <font  face=\"Verdana\" size=\"5\"> Choisissez la methode de recherche :     </font> </p>\n");
      out.write("             <form  method=POST action=Rservlet>  \n");
      out.write("\t\t\t  <p align=\"center\"> \n");
      out.write("            <table >   \n");
      out.write("         <tr><td ><font  face=\"Verdana\" size=\"5\"> Par Cote : </font><td><input type=\"radio\" value=\"cote\" name=\"choixRecherche\" > </td> </tr>\n");
      out.write("         <tr><td><font  face=\"Verdana\" size=\"5\"> Par Dicsipline : </font><td><input type=\"radio\" value=\"dicsipline\" name=\"choixRecherche\" >  </td></tr>\n");
      out.write("         <tr> <td> <font  face=\"Verdana\" size=\"5\"> Par Sous_Discipline : </font><td><input type=\"radio\" value=\"sous_dicsipline\" name=\"choixRecherche\" > </td> </tr>\n");
      out.write("           \n");
      out.write("       \n");
      out.write("         <tr> <td colspan=\"2\" height=\"200\" align=\"center\">  <input type=\"submit\" value=\"Valider\" name=\"submit\" style=\"width:200px;height:50px\" class=\"bouton\" >  </td></tr> \n");
      out.write("             </table>\n");
      out.write("\t\t\n");
      out.write("         </form >  \n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
