package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class Checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      JavaBean.PizzaOrderBean bean = null;
      synchronized (session) {
        bean = (JavaBean.PizzaOrderBean) _jspx_page_context.getAttribute("bean", PageContext.SESSION_SCOPE);
        if (bean == null){
          bean = new JavaBean.PizzaOrderBean();
          _jspx_page_context.setAttribute("bean", bean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html><html><head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>CT's Pizzeria</title>\n");
      out.write("</head><body bgcolor=\"#FDF5E6\" background=\"pizzalogo.png\" style=\"background-repeat:no-repeat; background-position: right;\">\n");
      out.write("<h1 style=\"color:#FF6600\">CT's Pizzeria</h1>\n");
      out.write("<p><b>Order Information:</b></p>\n");
      out.write("\n");
      out.write("<!--<p>Type: <br/>\n");
      out.write("   Amount: <br/>\n");
      out.write("   Price: <br/>\n");
      out.write("   Total Price: <br/></p>-->\n");
      out.write("\n");

//out.print( bean.getRegular());
//out.print( bean.getSupreme());
//out.print( bean.getVege());
out.print("<p>Type: <br/>");
out.print("Amount: <br/>");
out.print("Price: </p>");
out.print("<p>Total Price: $" + bean.getTotal() + "</p>");

      out.write("\n");
      out.write("\n");
      out.write("<p>Today is <SCRIPT LANGUAGE = \"JavaScript\"><!--\n");
      out.write("// Array of day names\n");
      out.write("var dayNames = new Array(\"Sunday\",\"Monday\",\"Tuesday\",\"Wednesday\",\"Thursday\",\"Friday\",\"Saturday\");\n");
      out.write("var monthNames = new Array(\"January\",\"February\",\"March\",\"April\",\"May\",\"June\",\"July\",\n");
      out.write("                           \"August\",\"September\",\"October\",\"November\",\"December\");\n");
      out.write("var dt = new Date();\n");
      out.write("var y  = dt.getYear();\n");
      out.write("// Y2K compliant\n");
      out.write("if (y < 1000) y +=1900;\n");
      out.write("document.write(dayNames[dt.getDay()] + \", \" + monthNames[dt.getMonth()] + \" \" + dt.getDate() + \", \" + y);\n");
      out.write("// --></SCRIPT></p>\n");
      out.write("\n");
      out.write("<p><i>Thank You For Ordering from CT's Pizzeria!</i></p>\n");
      out.write("</body></html>");
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
