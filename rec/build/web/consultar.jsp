<%-- 
    Document   : consultar
    Created on : 11 de mai. de 2023, 09:29:28
    Author     : lucas.ssantos154
--%>

<%@page import="Model.Medicamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>



        <% //Including Java code on the HTML body
            Medicamento medicamento = (Medicamento) request.getAttribute("Medicamento");
        %>

        <div>
            <p><label>ID: <label><%= medicamento.getId()%></label></label></p>
       <p> <label>Nome: <label><%= medicamento.getNome()%></label></label></p>
    </div>


</body>
</html>
