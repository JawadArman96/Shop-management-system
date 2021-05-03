<%-- 
    Document   : SerachProduct
    Created on : Dec 14, 2016, 7:55:15 PM
    Author     : ASUS
--%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop ManagementApp</title>
    </head>
    <body>
        <h1>Search Product</h1>
        <form method="post" action="SerachProduct.do" >
        
        <% List<String> rows= (List<String>)session.getAttribute("SelectedRows");
            int count=rows.size();
            out.println(String.format("Total %d Categories found",count));
            out.println("<select");
            out.println("name=");
            out.println("category");
            out.println(">");
            int i;
            for(i=0;i<count;i++){
                out.println("<option ");
                out.println("value=");
                out.println(rows.get(i));
                out.println(">");
                out.println(rows.get(i));
                out.println("</option>");
            }
            out.println("</select>");
        %> 
       
        <input type="submit" value="search" />
        </form>
       </body>
</html>
