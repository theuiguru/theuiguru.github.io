package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("<!DOCTYPE html><html><head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>CT's Pizzeria</title>\n");
      out.write("</head><body bgcolor=\"#FDF5E6\" background=\"pizzalogo.png\" style=\"background-repeat:no-repeat; background-position: right;\">\n");
      out.write("<h1 style=\"color:#FF6600\">CT's Pizzeria</h1>\n");
      out.write("<p><b>Enter in the amount of pizzas you would like to order for each topping:</b></p>\n");
      out.write("<form method=\"POST\" action=\"/FinalProject/PizzaServlet\">\n");
      out.write("    <p>Regular ($8): <input type=\"text\" name=\"regular\" maxlength=\"2\" size=\"2\" /></p>\n");
      out.write("    <p>Supreme ($10): <input type=\"text\" name=\"supreme\" maxlength=\"2\" size=\"2\" /></p>\n");
      out.write("    <p>Vegetarian ($10): <input type=\"text\" name=\"vege\" maxlength=\"2\" size=\"2\" /></p>\n");
      out.write("<p><input type=\"submit\" value=\"Put in Shopping Cart\" name=\"cart\" />\n");
      out.write("    <input type=\"submit\" value=\"Check Out\" name=\"cart\" /></p>\n");
      out.write("</form></body></html>");
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
