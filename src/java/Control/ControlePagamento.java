/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.CarrinhoDeCompra;
import Model.DAO.PagamentoDAO;
import Model.Pagamento;

import Model.Produto;
import Model.TipoPagamento;
import static Model.TipoPagamento.CARTAO_CREDITO;
import static Model.TipoPagamento.CARTAO_DEBITO;
import static Model.TipoPagamento.DINHEIRO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
public class ControlePagamento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlePagamento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlePagamento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("removePagamento")) {
            int id = 0;
            id = Integer.parseInt(request.getParameter("idProduto"));
            //recupera a sessão pertencente ao request
            HttpSession sessao = request.getSession();
            //recupera um carrinho de produtos da sessão
            CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
            //recupera o id do produto
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
            Pagamento pagamento = new Pagamento();
            pagamento.setId(id);
            carrinho.removerPagamento(pagamento);
            //carrega a pagina do carrinho de compras
            request.getRequestDispatcher("/pagamento.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String botao = request.getParameter("botao");
        if (botao.equals("REGISTRAR")) {
            Pagamento pagamento = new Pagamento();
            pagamento.setId_Pedido((int) sessao.getAttribute("idPedido"));
            pagamento.setTipo_pag((String) request.getParameter("FormaPagamento"));
            pagamento.setQuantia(Double.parseDouble(request.getParameter("valorRecebido")));

            PagamentoDAO pagamentoDAO = new PagamentoDAO();
            int idPag = pagamentoDAO.gravarPagamento(pagamento);
            if (idPag != 0) {
                pagamento.setId(idPag);
                CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
                carrinho.addPagamento(pagamento);
                carrinho.calculaTotalPago();
                request.getRequestDispatcher("/pagamento.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
