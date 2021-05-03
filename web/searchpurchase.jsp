<%-- 
    Document   : searchpurchase
    Created on : Dec 15, 2016, 5:27:25 AM
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
        <h1>View report</h1>
        <form method="post" action="SerachPurchase.do" >
             Enter 1st Date <input type="Date" name="first_date" /> <br/>
             Enter 2nd Date <input type="Date" name="second_date" /> <br/>
             <input type="submit" value="search" />
    </body>
</html>
