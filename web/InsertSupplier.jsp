<%-- 
    Document   : InsertSupplier
    Created on : Dec 15, 2016, 12:15:51 AM
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
        <h1>Provide Supplier Info</h1>
        <form method="post" action="InsertSupplier.do">
            <%--Supplier Id<input type="text" name="supplierId" > <br/> --%>
            Name<input type="text" name="name" > <br/>
            Location<input type="text" name="location" > <br/>
            Branch Id <input type="text" name="branchId" > <br/>
            <%--Product Id <input type="text" name="productId" > <br/> --%>
            <input type="submit" value="create" />
        </form>
    </body>
</html>
