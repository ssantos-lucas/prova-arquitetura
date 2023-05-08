<%-- 
    Document   : alterarFuncById
    Created on : 5 de mai. de 2023, 10:44:43
    Author     : lucas.ssantos154
--%>

<%@page import="model.Funcionario"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Funcionario Func = (Funcionario) request.getAttribute("Funcionario");
        %>
        <form method="POST" action="Controle">
            <input type="hidden" name="flag" value="alterar">
            <p>
                <label for="matriculaFuncionarioo" style="margin-bottom: 30px"> Matricula: </label>
                <input type="text" name="matriculaFuncionario" id="matriculaFuncionario" value="<%= request.getParameter("matriculaFuncionario")%>" readonly style="display: block">
            </p>
            <p>
                <label for="nomeFuncionario" style="margin-bottom: 30px"> Nome: </label>
                <input type="text" name="nomeFuncionario" id="nomeFuncionario" value="<%= request.getParameter("nomeFuncionario")%>" style="display: block">
            </p>
            <p>
                <label for="cargoFuncionario" style="margin-bottom: 30px"> Cargo: </label>
                <input type="text" name="cargoFuncionario" id="cargoFuncionario" value="<%= request.getParameter("cargoFuncionario")%>" style="display: block">
            </p>

            <p>
                <label for="idadeFuncionario" style="margin-bottom: 30px"> Idade: </label>
                <input type="text" name="idadeFuncionario" id="idadeFuncionario" value="<%= request.getParameter("idadeFuncionario")%>" style="display: block">
            </p>

            <p>
                <label for="salarioFuncionario" style="margin-bottom: 30px"> Salário: </label>
                <input type="text" name="salarioFuncionario" id="salarioFuncionario" value="<%= request.getParameter("salarioFuncionario")%>" style="display: block">
            </p>
            <p>
                <input type="submit" value="Salvar alteração" style="display: block">
            </p>
        </form>
    </body>
</html>
