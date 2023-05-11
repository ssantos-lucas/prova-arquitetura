<%-- 
    Document   : alterar
    Created on : 11 de mai. de 2023, 10:07:08
    Author     : lucas.ssantos154
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form method="POST" action="Controle">
            <input type="hidden" name="flag" value="alterar">
            <p>
                <label for="id" style="margin-bottom: 30px"> Id: </label>
                <input type="text" name="id" id="idProduto" value="<%= request.getParameter("id")%>" readonly style="display: block">
            </p>
            <p>
                <label for="nome" style="margin-bottom: 30px"> Nome: </label>
                <input type="text" name="nome" id="nome" value="<%= request.getParameter("nome")%>" style="display: block">
            </p>
            <p>
                <label for="tipo" style="margin-bottom: 30px"> Tipo: </label>
                <input type="text" name="tipo" id="tipo" value="<%= request.getParameter("tipo")%>" style="display: block">
            </p>
            <p>
                <label for="composicao" style="margin-bottom: 30px"> Composição: </label>
                <input type="text" name="composicao" id="composicao" value="<%= request.getParameter("composicao")%>" style="display: block">
            </p>
            <p>
                <label for="posologia" style="margin-bottom: 30px"> Posologia: </label>
                <input type="text" name="posologia" id="posologia" value="<%= request.getParameter("posologia")%>" style="display: block">
            </p>            
            <p>
                <label for="dosagem" style="margin-bottom: 30px"> Dosagem: </label>
                <input type="text" name="dosagem" id="dosagem" value="<%= request.getParameter("dosagem")%>" style="display: block">
            </p>
            <p>
                <label for="dosagem" style="margin-bottom: 30px"> Medida Dosagem: </label>
                <input type="text" name="medidaDosagem" id="medidaDosagem" value="<%= request.getParameter("medidaDosagem")%>" style="display: block">
            </p>
            <p>
                <label for="preco" style="margin-bottom: 30px"> Preço: </label>
                <input type="text" name="preco" id="preco" value="<%= request.getParameter("preco")%>" style="display: block">
            </p>

            <p>
                <input type="submit" value="Salvar alteração" style="display: block">
            </p>
        </form>


    </body>
</html>
