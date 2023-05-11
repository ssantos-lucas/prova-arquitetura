/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Medicamento;
import Model.MedicamentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        if (flag.equalsIgnoreCase("incluir")) {
            Medicamento med = new Medicamento();
            med.setId(Integer.parseInt(request.getParameter("id")));
            med.setNome(request.getParameter("nome"));
            med.setTipo(request.getParameter("tipo"));
            med.setComposicao(request.getParameter("composicao"));
            med.setPosologia(request.getParameter("posologia"));
            med.setDosagem(Integer.parseInt(request.getParameter("dosagem")));
            med.setMedidaDosagem(request.getParameter("medidaDosagem"));
            med.setPreco(Double.parseDouble(request.getParameter("preco")));
            int resultado = new MedicamentoDAO().incluirMedicamento(med);
            switch (resultado) {
                case 1:
                    mensagem = "Medicamento salvo com sucesso.";
                    break;
                case 2:
                    mensagem = "Produto já cadastrado.";
                    break;
                case 3:
                    mensagem = "Erro ao cadastrar o produto, contato um adm.";
                    break;
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("listarMedicamentos")) {
            List<Medicamento> medicamentos = new MedicamentoDAO().listarMedicamentos();
            request.setAttribute("listarMedicamentos", medicamentos);
            RequestDispatcher disp = request.getRequestDispatcher("ListarMedicamentos.jsp");
            disp.forward(request, response);

        } else if (flag.equalsIgnoreCase("consultar")) {
            int idMed = Integer.parseInt(request.getParameter("id"));
            MedicamentoDAO dao = new MedicamentoDAO();
            Medicamento med = dao.consultarMedicamento(idMed);
            if (med == null) {
                mensagem = "Produto não encontrado";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("Medicamento", med);
                RequestDispatcher disp = request.getRequestDispatcher("consultar.jsp");
                disp.forward(request, response);
            }
        } else if (flag.equalsIgnoreCase("excluir")) {
            int idMed = Integer.parseInt(request.getParameter("id"));
            MedicamentoDAO dao = new MedicamentoDAO();
            int resultado = dao.excluirMedicamento(idMed);
            if (resultado == 1) {
                mensagem = "Produto excluído com sucesso.";
            } else if (resultado == 2) {
                mensagem = "Produto com ID de " + idMed + " não existe.";
            } else {
                mensagem = "Erro ao tentar excluir o produto.";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
            disp.forward(request, response);
        } else if (flag.equalsIgnoreCase("alterar")) {
            int idMed = Integer.parseInt(request.getParameter("id"));
            String nomeMed = request.getParameter("nome");
            String tipo = request.getParameter("tipo");
            String comp = request.getParameter("composicao");
            String pos = request.getParameter("posologia");
            int dose = Integer.parseInt(request.getParameter("dosagem"));
            Double precoMed = Double.parseDouble(request.getParameter("preco"));
            MedicamentoDAO dao = new MedicamentoDAO();

            int resultado = dao.alterarMedicamento(idMed, nomeMed, tipo, comp, pos, dose, precoMed);
            if (resultado == 1) {
                mensagem = "Produto alterado com sucesso.";
            } else {
                mensagem = "Erro ao tentar alterar o departamento.";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
            disp.forward(request, response);
        }
        
        else if (flag.equalsIgnoreCase("buscar")) {
            int idMed = Integer.parseInt(request.getParameter("id"));
            MedicamentoDAO dao = new MedicamentoDAO();
            Medicamento med = dao.buscarMedicamento(idMed);
            if (med == null) {
                mensagem = "Produto não encontrado";
                request.setAttribute("m", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("Mensagens.jsp");
                disp.forward(request, response);
            } else {
                request.setAttribute("Medicamento", med);
                RequestDispatcher disp = request.getRequestDispatcher("alterarById.jsp");
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
