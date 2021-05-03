<%-- 
    Document   : InsertEmployee
    Created on : Dec 14, 2016, 7:15:04 PM
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
        <h1>Insert Employee</h1>
        <form method="post" action="InsertEmployee.do" >
            <%--Employee ID <input type="text" name="Employee_ID" /><br> --%>
            Name <input type="text" name="Name" /> <br/>
            Address <input type="text" name="Address" /> <br/>
            Join Date <input type="Date" name="JoinDate" /> <br/>
            Salary <input type="text" name ="Salary" /> <br/>
            Phone <input type="text" name ="Phone" /> <br/>
            <%--Password <input type="password" name ="Password" /> <br/>--%>
            <input type="submit" value="Create" />	
        </form>
            <%
            int count=(Integer)session.getAttribute("id");
            out.print("Last Allocated Employee ID:");
            out.println( String.format("<td>%d ",count));
        %>
    </body>
</html>
