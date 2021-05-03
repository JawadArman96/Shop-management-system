<%-- 
    Document   : updateproductquantity
    Created on : Dec 15, 2016, 10:31:06 PM
    Author     : gs
--%>
<%@page import="servlets.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter product name and number of products to add</h1>
        <form method="post" action="updateproductquantity.do">
            <% List<Products> rows= (List<Products>)session.getAttribute("SelectedRows");
            int count=rows.size();
            out.println(String.format("Total %d Poroduct found",count));
            out.println("<select");
            out.println("name=");
            out.println("Poroduct");
            out.println(">");
            int i;
            for(i=0;i<count;i++){
                out.println("<option ");
                out.println("value=");
                out.println(rows.get(i).productName);
                out.println(">");
                out.println(rows.get(i).productName);
                out.println("</option>");
            }
            out.println("</select>");
        %> 
            Qunatity<input type="text" name="quantity" > <br/>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
