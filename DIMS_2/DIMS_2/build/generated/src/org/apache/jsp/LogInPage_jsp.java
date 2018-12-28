package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LogInPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");

            String loginflag=(String)session.getAttribute("loginflag");
            if(loginflag=="No")out.println("Wrong User ID or Password");
        
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        <form method=\"post\" action=\"LoginProcessServlet.do\" onsubmit=\"return validate()\">\n");
      out.write("            Enter your User ID: <br/><input id=\"user_id\"type=\"text\" name=\"userid\" /> <br/>\n");
      out.write("            Enter your Password: <br/><input id = \"password\" type=\"password\" name=\"password\" /> <br/>\n");
      out.write("            <input type=\"submit\" value=\"Log\" />\n");
      out.write("        </form>\n");
      out.write("        <a href=\"HomePage.html\"><button type=\"button\">Back</button></a><br/>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function validate() {\n");
      out.write("    if (document.getElementById(\"user_id\").value == \"\" || document.getElementById(\"password\").value == \"\") {\n");
      out.write("         alert(\"user_id or password fields are empty\");\n");
      out.write("         return false;\n");
      out.write("    } else {\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("}\n");
      out.write("         </script>\n");
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
