<%-- 
    Document   : ViewProduct
    Created on : Dec 15, 2016, 1:47:20 AM
    Author     : ASUS
--%>
<%@page import="java.lang.System.out"%>
<%@page import="java.util.List"%>
<%@page import="servlets.Products"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop ManagementApp</title>
        <style> 
        table, th, td {
            border: 1px solid black;
        }
        </style>>
    </head>
    <body>
        
        <h1>View All Products</h1>
        <table style="width:100%">
          <tr>
            <th>Product Id</th>
            <th>Price</th>
            <th>Category</th>
            <th>Product Name</th>
            <th>Quantity</th>
          </tr>
          <%
              List<Products> ob= (List<Products>) session.getAttribute("products");
              for(Products x: ob){
                  out.println("<th>");
                  out.println( String.format("<td>%d ",x.productId));
                  out.println("</th>");
              }
          %>        
        </table>
    </body>
</html>
