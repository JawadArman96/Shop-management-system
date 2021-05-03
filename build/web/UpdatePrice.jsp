<%-- 
    Document   : UpdatePrice
    Created on : Dec 16, 2016, 3:02:40 PM
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
        <h1>Update Product Price</h1>
        <form method="post" action="UpdatePrice.do">
            Product id <input type="text" name="productId" /><br>
            Price<input type="text" name ="price" /> <br/>
            <input type="submit" value="Create" />
            
        </form>
    </body>
</html>
