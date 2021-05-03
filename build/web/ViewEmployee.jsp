<%-- 
    Document   : ViewEmployee
    Created on : Dec 21, 2016, 12:11:52 AM
    Author     : ASUS
--%>
<%@page import="java.util.List"%>
<%@page import="servlets.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop ManagementApp</title>
        <style> 
        table, th, td {
            border: 1px solid black;
        }
        </style>
    </head>
    <body>
        <h1>View Employee!</h1>
            <form method="post" action="home.do" >
              <input type="submit" value="GO TO HOME" />
        </form>
        <table style="width:100%"></table>
          <%
               List<Employee> rows= (List<Employee>) session.getAttribute("SelectedRows");
            if(rows==null)
            {
                out.println("No Employee found");
            }
            else if(rows.size()==0)
            {
                out.println("No Employee exist.");
            }
            else 
            {
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Employee Id</th>");
                out.println("<th>Name</th>");
                out.println("<th>Address</th>");
                out.println("<th>Join Date Name</th>");
                out.println("<th>Salary</th>");
                out.println("<th>Phone</th>");
                out.println("</tr>");
                int count=0;
                for(Employee row: rows)
                {
                    count++;
                    out.println("<tr>");
                    out.println("<th>");out.print( String.format("%d ",row.employeeId));out.println("</th>");
                    out.println("<th>");out.print( String.format("%s ",row.name));out.println("</th>");
                    out.println("<th>");out.print( String.format("%s ",row.address));out.println("</th>");
                    out.println("<th>"); out.print( String.format("%s ",row.joinDate));out.println("</th>");
                    out.println("<th>");out.print(String.format("%s",row.phone));out.println("</th>");
                    out.println("<th>");out.print(String.format("%d",row.salary));out.println("</th>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
          %>        
        </table>
    </body>
</html>
