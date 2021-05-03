package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import servlets.SerachProduct;
import servlets.Products;

public final class ShowStatement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Shop ManagementApp</title>\n");
      out.write("        <style> \n");
      out.write("        table, th, td {\n");
      out.write("            border: 1px solid black;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      ");
      out.write("\n");
      out.write("        <h1>Selected Rows for Products</h1>\n");
      out.write("        <form method=\"post\" action=\"home.do\" >\n");
      out.write("              <input type=\"submit\" value=\"GO TO HOME\" />\n");
      out.write("        </form>\n");
      out.write("        <table style=\"width:100%\"></table>\n");
      out.write("          \n");
      out.write("       ");

        List<Products> rows= (List<Products>) session.getAttribute("SelectedRows");
            if(rows==null)
            {
                out.println("No rows found");
            }
            else if(rows.size()==0)
            {
                out.println("No such Product exist.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Product Id</th>");
                out.println("<th>Price</th>");
                out.println("<th>Category</th>");
                out.println("<th>Product Name</th>");
                out.println("<th>Quantity</th>");
                out.println("</tr>");
                int count=0;
                for(Products row: rows)
                {
                    count++;
                    out.println("<tr>");
                    out.println("<th>");out.print( String.format("%d ",row.productId));out.println("</th>");
                    out.println("<th>");out.print( String.format("%d ",row.price));out.println("</th>");
                    out.println("<th>");out.print( String.format("%s ",row.category));out.println("</th>");
                    out.println("<th>"); out.print( String.format("%s ",row.productName));out.println("</th>");
                    out.println("<th>");out.print(String.format("%d",row.quantity));out.println("</th>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("      \n");
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
