<%-- 
    Document   : ShowStatement
    Created on : Dec 14, 2016, 8:36:30 PM
    Author     : ASUS
--%>
<%@page import="java.util.List"%>
<%@page import="servlets.SerachProduct"%>
<%@page import="servlets.Purchase"%>
<!DOCTYPE html>
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
        </style>
    </head>
    <body>
      <%-- <form method="post" action="SerachProduct.do" >
             Enter Category <input type="text" name="category" /> <br/>
             <input type="submit" value="search" />
        </form> --%>
        <h1>Selected Rows for Purchase Report</h1>
        <form method="post" action="home.do" >
             <input type="submit" value="GO TO HOME" /> 
        </form>
        <table style="width:100%"></table>
        
       <%
        List<Purchase> rows = (List<Purchase>) session.getAttribute("SelectedRows");
        int totalamount = (Integer) session.getAttribute("amount");
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
                out.println("<th>Product Name</th>");
                out.println("<th>Purchase Id</th>");
                out.println("<th>Product Id</th>");
                out.println("<th>Quantity</th>");
                out.println("<th>Purchase Date</th>");
                out.println("<th>Customer Id</th>");
                out.println("</tr>");
                int count=0;
                for(Purchase row: rows)
                {
                    count++;
                    out.println("<tr>");
                    out.println("<th>"); out.print( String.format("%s ",row.purchaseName));out.println("</th>");
                    out.println("<th>");out.print( String.format("%d ",row.purchaseId));out.println("</th>");
                    out.println("<th>");out.print( String.format("%d ",row.productId));out.println("</th>");
                    out.println("<th>");out.print( String.format("%d ",row.quantity));out.println("</th>");
                    out.println("<th>"); out.print( String.format("%s ",row.purchaseDate));out.println("</th>");
                    out.println("<th>");out.print(String.format("%d",row.customerId));out.println("</th>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("Total sales amount "+totalamount);
            }
        %>
        
        
    </body>
</html>
