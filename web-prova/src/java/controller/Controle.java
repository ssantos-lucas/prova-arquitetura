/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import model.FuncionarioDAO;

/**
 *
 * @author lucas.ssantos154
 */
@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String flag, mensagem = null;
        flag = request.getParameter("flag");

        if (flag.equalsIgnoreCase("cadastro")) {
            Funcionario func = new Funcionario();
            func.setMatricula(request.getParameter("matriculaFuncionario"));
            func.setNome(request.getParameter("nomeFuncionario"));
            func.setCargo(request.getParameter("cargoFuncionario"));
            func.setIdade(Integer.parseInt(request.getParameter("idadeFuncionario")));
            func.setSalario(Double.parseDouble(request.getParameter("salarioFuncionario")));

            int resultado = new FuncionarioDAO().salvarFuncionario(func);
            switch (resultado) {
                case 1:
                    mensagem = "Funcionario salvo com sucesso.";
                    break;
                case 2:
                    mensagem = "Funcionario já cadastrado.";
                    break;
                case 3:
                    mensagem = "Erro ao cadastrar o Funcionario, contate um administrador.";
                    break;
                default:
                    break;
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagem.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("listarFuncionario")) {
            List<Funcionario> funcionarios = new FuncionarioDAO().listarFuncionarios();
            request.setAttribute("listarFuncionarios", funcionarios);
            RequestDispatcher disp = request.getRequestDispatcher("listar.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("excluirFuncionario")) {
            String matricula = request.getParameter("matricula");
            FuncionarioDAO dao = new FuncionarioDAO();
            int resultado = dao.excluirFuncionario(matricula);
            if (resultado == 1) {
                mensagem = "Funcionario excluído com sucesso.";
            } else if (resultado == 2) {
                mensagem = "Funcionario com matricula " + matricula + " não existe.";
            } else {
                mensagem = "Erro ao tentar excluir o funcionario.";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagem.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("alterar")) {
            String matricula = request.getParameter("matriculaFuncionario");
            String nome = request.getParameter("nomeFuncionario");
            String cargo = request.getParameter("cargoFuncionario");
            int idade = (Integer.parseInt(request.getParameter("idadeFuncionario")));
            double salario =(Double.parseDouble(request.getParameter("salarioFuncionario")));
            FuncionarioDAO dao = new FuncionarioDAO();
            int resultado = dao.alterarFuncionario(matricula, nome, cargo, idade, salario);
            if (resultado == 1) {
                mensagem = "Funcionario alterado com sucesso.";
            } else {
                mensagem = "Erro ao tentar alterar o Funcionario.";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagem.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("buscar")) {
            String matricula = request.getParameter("matriculaFuncionario");
            String nome = request.getParameter("nomeFuncionario");
            String cargo = request.getParameter("cargoFuncionario");
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario func = dao.buscarFuncionario(matricula);
            if (func == null) {
                mensagem = "Funcionario não encontrado";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("Mensagem.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("Funcionario", func);
                RequestDispatcher disp = request.getRequestDispatcher("alterarFuncById.jsp");
                disp.forward(request, response);
            }
        }
        else if (flag.equalsIgnoreCase("consultar")) {
            String matricula = request.getParameter("matricula");
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario func = dao.consultarFuncionario(matricula);
                    
            if (func == null) {
                mensagem = "Produto não encontrado";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("Mensagem.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("Produto", func);
                RequestDispatcher disp = request.getRequestDispatcher("consultar.jsp");
                disp.forward(request, response);
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
