<%-- 
    Document   : productoptions
    Created on : Dec 15, 2016, 10:47:23 PM
    Author     : gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Select an option</h1>
        <form method="post" action="productoptions.do">
             <input type="radio" name="select" value="Product" />Insert Product <br>
             <input type="radio" name="select" value="Quantity" />Add product <br>
             <input type="radio" name="select" value="Price" />Update Price <br>
            <input type="submit" value="GO"/>
        </form>
    </body>
</html>
