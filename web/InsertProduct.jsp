<%-- 
    Document   : InsertProduct
    Created on : Dec 14, 2016, 7:19:22 PM
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
        <h1>Insert Product</h1>
        <form method="post" action="InsertProduct.do">
            <%--Product id <input type="text" name="productId" /><br>--%>
            Category <input type="text" name="CATEGORY" /> <br/>
            Price <input type="text" name="PRICE" /> <br/>
            Product Name <input type="text" name="PRODUCT_NAME" /> <br/>
            Quantity <input type="text" name ="Quantity" /> <br/>
            <input type="submit" value="Create" />
            
        </form>
    </body>
</html>
