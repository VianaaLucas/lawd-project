/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.DAO.PedidoCompraDAO;
import Model.Fornecedor;
import Model.PedidodeCompra;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
public class ControlePedidoCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlePedidoCompra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlePedidoCompra at " + request.getContextPath() + "</h1>");
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
        String acao = request.getParameter("botao");
        HttpSession sessao = request.getSession();
        if (acao.equals("CONSULTAR")){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(parseInt(request.getParameter("fornecedor")));
            PedidoCompraDAO pedidoCompraDAO = new PedidoCompraDAO();
            List<PedidodeCompra> listaPedido = new ArrayList();
            listaPedido = pedidoCompraDAO.consultaPedidos(parseInt(request.getParameter("fornecedor")));
            sessao.setAttribute("pedidoCompra", listaPedido);
            request.getRequestDispatcher("/pedidoCompra.jsp").forward(request, response);
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
