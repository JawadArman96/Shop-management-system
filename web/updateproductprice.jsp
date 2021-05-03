<%-- 
    Document   : updateproductprice
    Created on : Dec 15, 2016, 10:00:56 PM
    Author     : gs
--%>
<%@page import="java.util.List"%>
<%@page import="servlets.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter product name and new price</h1>
        <form method="post" action="updateproductprice.do">
            <% List<Products> rows= (List<Products>)session.getAttribute("SelectedRows");
            int count=rows.size();
            out.println(String.format("Total %d Poroduct found",count));
            out.println("<select");
            out.println("name=");
            out.println("Product");
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
            Price<input type="text" name="PRICE" > <br/>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
