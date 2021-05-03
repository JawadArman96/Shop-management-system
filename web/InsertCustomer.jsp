<%-- 
    Document   : InsertCustomer
    Created on : Dec 14, 2016, 6:50:45 PM
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
        <h1>Provide Customer Info</h1>
        <form method="post" action="InsertCustomer.do">
            NAME <input type="text" name="NAME" /> <br/>
            PHONE_NO <input type="text" name="PHONE_NO" /> <br/>
            EMAIL_ID <input type="text" name="EMAIL_ID" /> <br/>
            ADDRESS <input type="text" name ="ADDRESS" /> <br/>
            <input type="submit" value="Create" />
        </form>
        
    </body>
</html>
