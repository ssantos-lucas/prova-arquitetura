<%-- 
    Document   : AlterarById
    Created on : 11 de mai. de 2023, 10:13:25
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

        <%
            Medicamento med = (Medicamento) request.getAttribute("Medicamento");
        %>
        <form method="POST" action="Controle">
            <input type="hidden" name="flag" value="alterar">
            <p>
                <label for="id" style="margin-bottom: 30px"> Código: </label>
                <input type="text" name="id" id="id" value="<%= med.getId()%>" readonly style="display: block">
            </p>
            <p>
                <label for="nome" style="margin-bottom: 30px"> Nome: </label>
                <input type="text" name="nome" id="nome" value="<%= med.getNome()%>" style="display: block">
            </p>
            <p>
                <label for="tipo" style="margin-bottom: 30px"> Tipo: </label>
                <input type="text" name="tipo" id="tipo" value="<%= med.getTipo()%>" style="display: block">
            </p>
            <p>
                <label for="composicao" style="margin-bottom: 30px"> Composição: </label>
                <input type="text" name="composicao" id="composicao" value="<%= med.getComposicao()%>" style="display: block">
            </p>
            <p>
                <label for="posologia" style="margin-bottom: 30px"> Posologia: </label>
                <input type="text" name="posologia" id="posologia" value="<%= med.getPosologia()%>" style="display: block">
            </p>
            <p>
                <label for="dosagem" style="margin-bottom: 30px"> Dosagem: </label>
                <input type="text" name="dosagem" id="dosagem" value="<%= med.getDosagem()%>" style="display: block">
            </p>
            <p>
                <label for="medidaDosagem" style="margin-bottom: 30px"> Medida: </label>
                <input type="text" name="medidaDosagem" id="medidaDosagem" value="<%= med.getMedidaDosagem()%>" style="display: block">
            </p>
            <p>
                <label for="preco" style="margin-bottom: 30px"> Preço: </label>
                <input type="text" name="preco" id="preco" value="<%= med.getPreco()%>" style="display: block">
            </p>
            <p>
                <input type="submit" value="Salvar alteração" style="display: block">
            </p>
        </form>



    </body>
</html>
