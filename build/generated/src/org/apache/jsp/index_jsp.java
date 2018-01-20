package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <!-- Compiled and minified CSS -->\n");
      out.write(" <link rel=\"stylesheet\" href=\"css/materialize.min.css\">\n");
      out.write(" <!-- Compiled and minified JavaScript -->\n");
      out.write(" \n");
      out.write(" \n");
      out.write(" <link rel=\"stylesheet\" href=\"./assets/index.css\"/>\n");
      out.write(" <style>\n");
      out.write("     .h__{\n");
      out.write("         width: 100%;\n");
      out.write("         height: 700px;\n");
      out.write("         background: url(\"assets/material.jpg\")no-repeat center;\n");
      out.write("         padding-top: 200px;\n");
      out.write("         text-align: center;\n");
      out.write("     }\n");
      out.write("     .A{\n");
      out.write("         background-color: transparent;\n");
      out.write("         color: #fff;\n");
      out.write("     }\n");
      out.write("     .c2{\n");
      out.write("         width: 100%;\n");
      out.write("     }\n");
      out.write(" </style>\n");
      out.write("</head>\n");
      out.write("<body b>\n");
      out.write("     </script>\n");
      out.write("  <nav>\n");
      out.write("  \t<div class=\"nav-wrapper div_head\">\n");
      out.write("      <img class=\"responsive-img\" src=\"./cache/favicon.png\" width=\"40px\" height=\"40px\"/>\n");
      out.write("  \t\t<a href=\"Main\" class=\"brand-logo\">ProjectHub2</a>\n");
      out.write("  \t\t<ul class=\"right hide-on-med-and-down\">\n");
      out.write("  \t\t\t<li><a href=\"SignUp\"><i class=\"mdi-action-search left\"></i>Sign up</a></li>\n");
      out.write("  \t\t\t<li><a href=\"Login\"><i class=\"mdi-action-view-module right\"></i>Login</a></li>\n");
      out.write("        <li><a href=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${url3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("><i class=\"mdi-action-view-module right\"></i>Search</a></li>\n");
      out.write("  \t\t</ul>\n");
      out.write("  \t</div>\n");
      out.write("  </nav>\n");
      out.write("                \n");
      out.write("                    <div class=\"h__\">\n");
      out.write("                    <h3 style=\"color: #fff\">Welcome to ProjectHub</h3>\n");
      out.write("                    <p style=\"margin: 10px auto; width: 50%; color: #fff\">\"Most good programmers do programming not because they expect to get paid or \n");
      out.write("                    get adulation by public but because it's fun to write code.\" -Linus Trovalds</p>\n");
      out.write("                    <a href=\"Explore.jsp\"  class=\"btn A\">Explore</a>\n");
      out.write("                    <a href=\"How.html\"  class=\"btn A\">Why ProjectHub?</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"c2\">\n");
      out.write("                    <div class=\"row\" style=\"margin: 20px auto; width: 95%\">\n");
      out.write("                        <div class=\"col s6\" style=\"padding-top: 60px\">\n");
      out.write("                            <h5 class=\"flow-text\">Share your Projects</h5>\n");
      out.write("                            <p>ProjectHub is basically a platform to share your projects without having to upload the source code,\n");
      out.write("                            You can use GitHub as the source of code base and provide some meaningful information about your projects which can be \n");
      out.write("                            made use by aspiring developers and tech enthusiasts. Everything on ProjectHub is free.</p>\n");
      out.write("                            <a href=\"SignUp\" class=\"btn\">Create a free account</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col s6\" style=\" height: 400px\">\n");
      out.write("                            <img src=\"assets/coding.gif\" width=\"100%\" height=\"400px\"/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\" style=\"margin-top: 30px\">\n");
      out.write("                    <div class=\"col s6\" style=\"height: 460px\">\n");
      out.write("                        <img src=\"assets/home_2.jpg\" width=\"100%\" height=\"400px\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col s6\" style=\"padding-top: 40px\">\n");
      out.write("                        <h5 class=\"flow-text\">Fix bugs through feedbacks</h5>\n");
      out.write("                        <p>ProjectHub provides a feedback for developers to provide valuable feedbacks, this feedbacks will allow you to correct the bugs,\n");
      out.write("                         improve the product and find new ideas.</p>\n");
      out.write("                        <a href=\"How.html\" class=\"btn\">Learn more</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("  <footer class=\"page-footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col l6 s12\">\n");
      out.write("          <h5 class=\"white-text\">Free for Everyone</h5>\n");
      out.write("          <p class=\"grey-text text-lighten-4\">ProjectHub is free for anyone to use.</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col l4 offset-l2 s12\">\n");
      out.write("          <h5 class=\"white-text\">Links</h5>\n");
      out.write("          <ul>\n");
      out.write("            <li><a class=\"grey-text text-lighten-3\" href=\"http://github.com/Narasimha1997\">Follow on gitHub</a></li>\n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer-copyright\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        For any queries contact: narasimhaprasannahn@gmail.com\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </footer>\n");
      out.write("\n");
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
