/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.DAO.RelatorioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class ControleRelatorio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControleRelatorio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControleRelatorio at " + request.getContextPath() + "</h1>");
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
        String botao = request.getParameter("botao");
        if (botao.equals("VENDAS")) {
            RelatorioDAO relatorioDAO = new RelatorioDAO();
            ArrayList<Double> lista = relatorioDAO.relatoriodevendas();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("relatorioVenda.jsp").forward(request, response);
        }else if (botao.equals("PAGAMENTOS")){
            RelatorioDAO relatorioDAO = new RelatorioDAO();
            ArrayList<ArrayList<Double>> pagamentos = relatorioDAO.relatoriodepamaentos();
            request.setAttribute("pagamentos", pagamentos);
            request.getRequestDispatcher("relatorioPagamentos.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
