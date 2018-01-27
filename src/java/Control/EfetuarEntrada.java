/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danilo machado
 */
public class EfetuarEntrada extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EfetuarEntrada</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EfetuarEntrada at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("botao").equals("ADICIONAR")) {
            try {

                Produto produto = new Produto();
                produto.setCodigo_barra(Long.parseLong(request.getParameter("cod")));
                produto.setQuantidade_estoque(Integer.parseInt(request.getParameter("quantidade")));
                ProdutoDAO entrada = new ProdutoDAO();

                if (entrada.realizaEntrada(produto) == true) {
                    request.setAttribute("msg", "Entrada de produto cadastrada com sucesso!!!");
                    request.getRequestDispatcher("estoque.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "Ocorreu uma falha ao cadastrar a entrada do produto!!!");
                    request.getRequestDispatcher("estoque.jsp").forward(request, response);
                }
            } catch (Exception e) {

            }
        }
    }
}
