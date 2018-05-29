/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Categoria;
import Model.DAO.DescontoDAO;
import Model.DAO.ProdutoDAO;
import Model.Desconto;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre.albuquerque
 */
@WebServlet(name = "DescontoProduto", urlPatterns = {"/DescontoProduto"})
public class ControleDesconto extends HttpServlet {

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
        String acao = (String) request.getParameter("acao");
        if (acao.equals("forcadesconto")) {
            Desconto desconto = new Desconto();
            Categoria categoria = new Categoria();
            categoria.setId(Integer.parseInt(request.getParameter("categoria")));
            desconto.setCategoria(categoria);
            desconto.setPercentualDeDesconto(Double.parseDouble(request.getParameter("desconto")));
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String botao = request.getParameter("botao");
        if (botao.equals("CADASTRAR")) {
            Desconto desconto = new Desconto();
            Categoria categoria = new Categoria();
            categoria.setId(Integer.parseInt(request.getParameter("selecao_categoria")));
            desconto.setCategoria(categoria);
            desconto.setPercentualDeDesconto(Double.parseDouble(request.getParameter("porcentagem")));
            DescontoDAO descontodao = new DescontoDAO();
            ProdutoDAO produtodao = new ProdutoDAO();
            List<Desconto> listadesconto = new ArrayList<>();
            double teste = descontodao.checaDesconto(desconto);
            if ( teste == 0) {

                listadesconto = produtodao.verificaLucro(desconto);
                if (listadesconto == null) {
                    boolean status = descontodao.desconto(desconto);
                    if (status == true) {
                        request.setAttribute("msg", "Desconto atribuido com sucesso!!!");
                        request.getRequestDispatcher("descontoCadastrar.jsp").forward(request, response);
                    } else {
                        request.setAttribute("msg", "Ocorreu uma falha ao atribuir o desconto!!!");
                        request.getRequestDispatcher("descontoCadastrar.jsp").forward(request, response);
                    }
                } else {
                    sessao.setAttribute("lista", listadesconto);
                    sessao.setAttribute("desc", desconto);
                    request.getRequestDispatcher("descontoLista.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("msg", "Há um desconto já ativo de " + teste + "%");
                request.getRequestDispatcher("descontoCadastrar.jsp").forward(request, response);
            }
        } else if (botao.equals("CONFIRMAR")) {
            Desconto desconto = (Desconto) sessao.getAttribute("desc");
            DescontoDAO descontodao = new DescontoDAO();
            boolean status = descontodao.desconto(desconto);
            if (status == true) {
                request.setAttribute("msg", "Desconto atribuido com sucesso!!!");
                request.getRequestDispatcher("descontoCadastrar.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Ocorreu uma falha ao atribuir o desconto!!!");
                request.getRequestDispatcher("descontoCadastrar.jsp").forward(request, response);
            }

        } else if (botao.equals("EXCLUIR")){
            Desconto desconto = new Desconto();
            Categoria categoria = new Categoria();
            categoria.setId(Integer.parseInt(request.getParameter("selecao_categoria")));
            desconto.setCategoria(categoria);
            desconto.setPercentualDeDesconto(Double.parseDouble(request.getParameter("porcentagem")));
            DescontoDAO descontodao = new DescontoDAO();
            boolean status = descontodao.inativaDesconto(desconto);
            if (status == true) {
                request.setAttribute("msg", "Desconto excluído com sucesso!!!");
                request.getRequestDispatcher("descontoConsultar.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Ocorreu uma falha ao excluir o desconto!!!");
                request.getRequestDispatcher("descontoConsultar.jsp").forward(request, response);
            }
        }

    }
}
