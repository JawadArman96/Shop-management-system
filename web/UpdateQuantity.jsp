<%-- 
    Document   : UpadateQuantity
    Created on : Dec 16, 2016, 3:00:01 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop ManagementApp</title>
    </head>
    <body>
        <h1>Update Product Quantity</h1>
        <form method="post" action="UpdateQuantity.do">
            Product id <input type="text" name="productId" /><br>
            Quantity <input type="text" name ="Quantity" /> <br/>
            <input type="submit" value="Create" />
            
        </form>
    </body>
</html>
