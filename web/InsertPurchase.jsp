<%-- 
    Document   : InsertPurchase
    Created on : Dec 14, 2016, 7:22:46 PM
    Author     : ASUS
--%>
<%@page import="servlets.InsertCustomer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop ManagementApp</title>
    </head>
    <body>
        <h1>Update Purchase</h1>
        <form method="post" action="InsertPurchase.do">
            <%--Purchase id <input type="text" name="purchaseId" /><br> --%>
            Product Name <input type="text" name="productName" /><br>
            Purchase Quantity <input type="text" name="PQUANTITY" /> <br/>
            Purchase Date <input type="Date" name="PURCHASE_DATE" /> <br/>
           <%-- Customer id <input type="text" name="CUSTOMER_ID" /> <br/> --%>
            <input type="submit" value="Create" />
        </form>
        <%
            int count=(Integer) session.getAttribute("availableP");
            out.print("Recently Purchased ID:");
            out.println( String.format("<td>%d ",count));
        %>
    </body>
</html>
