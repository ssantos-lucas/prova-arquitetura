<%-- 
    Document   : consultar
    Created on : 5 de mai. de 2023, 10:56:18
    Author     : lucas.ssantos154
--%>

<%@page import="model.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% //Including Java code on the HTML body
            Funcionario func = (Funcionario) request.getAttribute("Funcionario");
        %>
        <p>
        <label>Matricula: <label><%= func.getMatricula() %></label></label>
        <label> Nome: <label><%= func.getNome()%></label><br><br>
        <label> Idade: <label><%= func.getIdade()%></label><br><br>
        <label> Cargo: <label><%= func.getCargo()%></label><br><br>
        <label> Salario: <label><%= func.getSalario()%></label><br><br>
            </p>
    </body>
</html>
