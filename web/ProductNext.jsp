<%-- 
    Document   : productNext
    Created on : Dec 16, 2016, 1:07:05 PM
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
        <h1>Select Option</h1>
        <form method="post" action="ProductNext.do" >
            <input type="radio" name="select" value="insert" />Insert Product <br>
            <input type="radio" name="select" value="update" />Update Product <br>
            <input type="submit" value="GO" />
        </form>
    </body>
</html>
