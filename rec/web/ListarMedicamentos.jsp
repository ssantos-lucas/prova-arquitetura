<%-- 
    Document   : ListarMedicamentos
    Created on : 11 de mai. de 2023, 09:15:46
    Author     : lucas.ssantos154
--%>

<%@page import="java.util.List"%>
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
            List<Medicamento> listarMedicamentos = (List<Medicamento>) request.getAttribute("listarMedicamentos");
        %>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Tipo</th>
                <th>Composição</th>
                <th>Posologia</th>
                <th>Dosagem</th>
                <th>Medida Dosagem</th>
                <th>Preço</th>  


            </tr>
            <%
                for (Medicamento medicamento : listarMedicamentos) {
            %>
            <tr>
                <td><%=  medicamento.getId() %></td>
                <td><%=  medicamento.getNome() %></td>
                <td><%=  medicamento.getTipo() %></td>
                <td><%=  medicamento.getComposicao()%></td>
                <td><%=  medicamento.getPosologia()%></td>
                <td><%=  medicamento.getDosagem()%></td>
                <td><%=  medicamento.getMedidaDosagem()%></td>
                <td><%=  medicamento.getPreco()%></td>
            </tr>
            <%
                }
            %>
        </table>


    </body>
</html>
