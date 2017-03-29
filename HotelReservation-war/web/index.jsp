<%-- 
    Document   : index
    Created on : 24-Mar-2017, 10:38:57 PM
    Author     : damil
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="session.CustomerRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            try{
        Context ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("java:module/myData");
        
        Connection con = ds.getConnection();
        
         Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from Customers");
           
           out.print(rs);
         
            }
           
            catch(Exception e){
            out.print(e.getMessage());
            }

        
        %>
    </body>
</html>
