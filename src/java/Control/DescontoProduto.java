/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Categoria;
import Model.DAO.DescontoDAO;
import Model.Desconto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre.albuquerque
 */
@WebServlet(name = "DescontoProduto", urlPatterns = {"/DescontoProduto"})
public class DescontoProduto extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DescontoProduto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DescontoProduto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Desconto desconto = new Desconto();
        Categoria categoria = new Categoria();
        categoria.setId(Integer.parseInt(request.getParameter("selecao_categoria")));
        desconto.setCategoria(categoria);
        desconto.setPercentualDeDesconto(Double.parseDouble(request.getParameter("porcentagem")));
        DescontoDAO descontodao = new DescontoDAO();
        boolean status = descontodao.desconto(desconto);
        if (status == true) {
            request.setAttribute("msg", "Desconto atribuido com sucesso!!!");
                request.getRequestDispatcher("descontoCadastrar.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Ocorreu uma falha ao atribuir o desconto!!!");
                request.getRequestDispatcher("descontoCadastrar.jsp").forward(request, response);
            }
    }
}
