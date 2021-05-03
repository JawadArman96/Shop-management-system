<%-- 
    Document   : UpdateProduct
    Created on : Dec 16, 2016, 1:28:27 PM
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
        <h1>Update Product</h1>
        <form method="post" action="UpdateProduct.do" >
             <input type="radio" name="upd" value="updateQuantity" />Update Quantity <br>
             <input type="radio" name="upd" value="updatePrice" />Update Price <br>
            <input type="submit" value="Update" />
        </form>
    </body>
</html>
