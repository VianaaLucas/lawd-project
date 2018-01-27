<%-- 
    Document   : erro
    Created on : 27/11/2017, 18:14:01
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro!</title>
    </head>
    <%
        Exception erro = (Exception) request.getAttribute("erro");
    %>
    <body>
        <h1>erro! <%=erro%></h1>
    </body>
</html>
