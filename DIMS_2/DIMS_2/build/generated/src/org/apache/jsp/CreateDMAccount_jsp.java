package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CreateDMAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Create New DepoManager Account</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <form method=\"post\" action=\"AddNewDM.do\" onsubmit=\"return validate()\">\n");
      out.write("            Enter First Name: <br/><input type=\"text\" name=\"first_name\" /> <br/>\n");
      out.write("            Enter Last Name : <br/><input type=\"text\" name=\"last_name\" /> <br/>\n");
      out.write("            Enter Password  : <br/><input type=\"password\" name=\"password\" /> <br/>\n");
      out.write("            Enter Salary : <br/><input type=\"text\" name=\"salary\" /> <br/>\n");
      out.write("            Enter Area ID : <br/><input type=\"text\" name=\"area_id\" /> <br/>\n");
      out.write("            <br/>\n");
      out.write("            <input type=\"submit\" value=\"Create\" /><br/>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        <a href=\"MDHome.jsp\"><button type=\"button\">Back</button></a><br/>\n");
      out.write("        <br/>\n");
      out.write("        \n");
      out.write("    <script>\n");
      out.write("            function validate() {\n");
      out.write("    if (document.getElementById(\"first_name\").value == \"\" || document.getElementById(\"last_name\").value==\"\"||document.getElementById(\"password\").value==\"\"||document.getElementById(\"salary\").value==\"\"|| document.getElementById(\"area_id\").value==\"\" ){\n");
      out.write("         alert(\"Enter All Fields\");\n");
      out.write("         return false;\n");
      out.write("    } else {\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("}\n");
      out.write(" </script> \n");
      out.write(" \n");
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
