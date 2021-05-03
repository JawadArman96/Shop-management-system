<%-- 
    Document   : deleteemployee
    Created on : Dec 16, 2016, 8:37:03 AM
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
        <h1>provide employee id to delete</h1>
      <form method="post" action="deleteemployee.do">
            Employee ID<input type="text" name="EMPLOYEE_ID" > <br/>
            <input type="submit" value="submit" />
       </form>  
    </body>
</html>
