package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class Rcote_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("                <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     <table class=\"ruban\"> \n");
      out.write("         <tr> <td> </td> </tr>\n");
      out.write("       </table> \n");
      out.write("        <font face=\"Verdana\" size=\"6\"> <p align=\"center\"> <b >  Selectionnez la cote de l'ouvrage désiré :  </b > </p>   </font>\n");
      out.write("\n");
      out.write("        <FORM method=\"post\" action=\"Recherche\" >\n");
      out.write("  <div align=\"center\"> \n");
      out.write(" <table  border='1px'  classe=\"tableau\"> \n");
      out.write(" <tr> <td width=\"150px\"height=\"50px\" cellpadding=\"0\"  >\n");
      out.write("<SELECT  name=\"scote\" size=\"1\" >\n");
      out.write("    \n");
      out.write("  <OPTION value=\"\"  > selectinner</OPTION >  \n");
      out.write("    \n");
      bdd.Utilitaire bean = null;
      synchronized (request) {
        bean = (bdd.Utilitaire) _jspx_page_context.getAttribute("bean", PageContext.REQUEST_SCOPE);
        if (bean == null){
          bean = new bdd.Utilitaire();
          _jspx_page_context.setAttribute("bean", bean, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
 ResultSet rs = bean.getRs();
    while (rs.next()) {
    String nom = rs.getString("cote");
                               

      out.write("\n");
      out.write("<OPTION value=\"");
      out.print( nom  );
      out.write("\" >");
      out.print( nom  );
      out.write("</OPTION >\n");
} 
      out.write("\n");
      out.write("\n");
      out.write("</SELECT>\n");
      out.write("</td> \n");
      out.write("<td> \n");
      out.write("<input type=\"submit\" value=\"Valider\" name=\"submit\" style=\"width:150px;height:50px\" class=\"bouton1\" > \n");
      out.write("</td> </tr>\n");
      out.write(" </table>\n");
      out.write("</div> \n");
      out.write("</FORM>\n");
      out.write("</body>\n");
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
