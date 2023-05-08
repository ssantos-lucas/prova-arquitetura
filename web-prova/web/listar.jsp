<%@page import="model.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% //Including Java code on the HTML body
            List<Funcionario> listarFuncionarios = (List<Funcionario>) request.getAttribute("listarFuncionarios");
        %>
        <table>
            <tr>
                <th>Matricula</th>
                <th>Nome</th>
                <th>Idade</th> 
                <th>Cargo</th>
                <th>Salario</th> 
            </tr>
            <%
                for (Funcionario func : listarFuncionarios) {
            %>
            <tr>
                <td> <%= func.getMatricula()%> </td> 
                <td> <%= func.getNome()%> </td>  
                <td> <%= func.getIdade()%> </td> 
                <td> <%= func.getCargo()%> </td>
                <td> <%= func.getSalario()%> </td>
                <td> <a href="Controle?flag=ExcluirFuncionario&matricula=<%=func.getMatricula()%>">Excluir</a> </td> 
                <td> <a href="alterarFuncionario.jsp?matricula=<%=func.getMatricula()%>&nome=<%=func.getNome()%>&idade=<%=func.getIdade()%>&cargo=<%=func.getCargo()%>&salario=<%=func.getSalario()%>">Alterar</a>
                </td></tr>
                <%
                    }
                %>
        </table>
    </body>
</html>




