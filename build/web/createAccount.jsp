<%-- 
    Document   : createAccount
    Created on : Dec 14, 2016, 6:47:37 PM
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
        <h1>Home</h1>
        <form method="post" action="CreateAccount.do">
             <input type="radio" name="select" value="Product" />Product <br>
             <input type="radio" name="select" value="Employee" />Employee <br>
             <input type="radio" name="select" value="Purchase" />Purchase <br>
             <input type="radio" name="select" value="SeacrhC" /> Search Product by Category <br>
             <input type="radio" name="select" value="ProductTable" />View Products<br>
             <input type="radio" name="select" value="Report" />View Report<br>
            <input type="submit" value="GO"/>
        </form>
    </body>
</html>
