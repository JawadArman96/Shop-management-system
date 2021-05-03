<%-- 
    Document   : employeeoptions
    Created on : Dec 16, 2016, 8:57:38 AM
    Author     : gs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop ManagementApp</title>
    </head>
    <body>
        <h1>Select an option</h1>
        <form method="post" action="employeeoptions.do">
             <input type="radio" name="opt" value="employee" />Add Employee <br>
             <input type="radio" name="opt" value="delete" />Delete Employee <br>
             <input type="radio" name="opt" value="view" />View Employee <br>
             <input type="submit" value="GO"/>
        </form>
    </body>
</html>
