package Control;

import Model.Categoria;
import Model.DAO.CategoriaDAO;
import Model.DAO.ParceiroDAO;
import Model.DAO.ProdutoDAO;
import Model.DAO.SubCatDAO;
import Model.Fornecedor;
import Model.Produto;
import Model.SubCategoria;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//select f.nome, f.email, p.descricao, p.estoque, p.qtdminima, p.qtdcompra 
//from fornecedor f, produto p 
//where p.fornecedor = f.id and p.estoque <= p.qtdminima
/**
 * @author lucas
 */
public class ControleProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //sessão destinada à consulta dinamica de dados para formulários
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("listacategoria")) {
                CategoriaDAO caddao = new CategoriaDAO();
                ArrayList<Categoria> listaCategoria = caddao.lista();
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaCategoria);
                out.write(listaJSON);
            } else if (acao.equals("listasubcategoria")) {
                int idcat = Integer.parseInt(request.getParameter("categoria"));
                //SubCategoria subcat = new SubCategoria();
                SubCatDAO subdao = new SubCatDAO();
                Categoria cat = new Categoria(idcat);
                List<SubCategoria> listaCats = subdao.listaParaCategoria(cat);
                //serializa para JSON
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaCats);
                out.write(listaJSON);
            } else if (acao.equals("listafornecedor")) {
                ParceiroDAO fornecedorDAO = new ParceiroDAO();
                ArrayList<Fornecedor> listaFornecedor = fornecedorDAO.lista();
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaFornecedor);
                out.write(listaJSON);
            } else if (acao.equals("listaProdutos")) {
                //monta uma lista para exibição na pagina principal
                ArrayList<Produto> produtos = new ProdutoDAO().listar();
                //armazena os produto na requisição 
                request.setAttribute("produtos", produtos);
                //envia para index.jsp
                request.getRequestDispatcher("/teste.jsp").forward(request, response);
            } else if (acao.equals("consultaProdutoPorCodigo")) {
                ProdutoDAO produtodao = new ProdutoDAO();
                Produto produto = new Produto(Long.parseLong(request.getParameter("codigo")));
                List<Produto> listaProduto = produtodao.consultarProdutoPorCodigo(produto);
                Gson gson = new Gson();
                String listaJSON = gson.toJson(listaProduto);
                out.println(listaJSON);
            }
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
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
        if (request.getParameter("botao").equals("ALTERAR")) {
            Produto produto = new Produto();
            Categoria categoria = new Categoria();
            SubCategoria subcategoria = new SubCategoria();
            Fornecedor fornecedor = new Fornecedor();
            ProdutoDAO prodDAO = new ProdutoDAO();
            produto.setDescricao(request.getParameter("descricao"));
            produto.setCodigo_barra(Long.parseLong(request.getParameter("codigo")));
            produto.setPreco_custo(Double.parseDouble(request.getParameter("precocusto")));
            produto.setPreco_venda(Double.parseDouble(request.getParameter("precovenda")));
            categoria.setId(Integer.parseInt(request.getParameter("categoria")));
            subcategoria.setId(Integer.parseInt(request.getParameter("subcategoria")));
            fornecedor.setId(Integer.parseInt(request.getParameter("fornecedor")));
            produto.setCategoria(categoria);
            produto.setSubCategoria(subcategoria);
            produto.setFornecedor(fornecedor);
            produto.setQtdcompra(Integer.parseInt(request.getParameter("qtdCompra")));
            produto.setQtdminima(Integer.parseInt(request.getParameter("qtdMinima")));
            if (prodDAO.alteraProduto(produto) == true) {
                request.setAttribute("msg", "Produto alterado com sucesso!!!");
                request.getRequestDispatcher("produtosConsultar.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Ocorreu uma falha ao alterar o produto!!!");
                request.getRequestDispatcher("produtosConsultar.jsp").forward(request, response);
            }
        } else if (request.getParameter("botao").equals("INATIVAR")) {
            Produto produto = new Produto(Long.parseLong(request.getParameter("codigo")));
            ProdutoDAO prodDAO = new ProdutoDAO();
            if (prodDAO.inativarProduto(produto) == true) {
                response.sendRedirect("produtosConsultar.html");
            } else {
                response.sendRedirect("produtosAlterar.jsp");
            }
        } else if (request.getParameter("botao").equals("CONSULTAR")) {
            long codigo = Long.parseLong(request.getParameter("codbarras"));
            Produto produto = new Produto(codigo);
            Produto produtoP = new Produto();
            ProdutoDAO prod = new ProdutoDAO();
            produtoP = prod.consultarPorCodigo(produto);
            if (produtoP != null) {
                request.setAttribute("descricao", produtoP.getDescricao());
                request.setAttribute("precoVenda", produtoP.getPreco_venda());
                request.setAttribute("precoCusto", produtoP.getPreco_custo());
                request.setAttribute("estoque", produtoP.getQuantidade_estoque());
                request.setAttribute("codigobarra", produtoP.getCodigo_barra());
                request.setAttribute("fornecedor", produtoP.getFornecedor().getId());
                request.setAttribute("categoria", produtoP.getCategoria().getId());
                request.setAttribute("subcategoria", produtoP.getSubCategoria().getId());
                request.setAttribute("qtdCompra", produtoP.getQtdcompra());
                request.setAttribute("qtdMinima", produtoP.getQtdminima());
                request.getRequestDispatcher("produtosAlterar.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Produto não encontrado!!!");
                request.getRequestDispatcher("produtosConsultar.jsp").forward(request, response);
            }

        } else if (request.getParameter("botao").equals("CADASTRAR")) {
            Produto produto = new Produto();
            ProdutoDAO cadProDAO = new ProdutoDAO();
            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setId(Integer.parseInt(request.getParameter("subcategoria")));
            produto.setSubCategoria(subCategoria);
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(Integer.parseInt(request.getParameter("fornecedor")));
            produto.setFornecedor(fornecedor);
            Categoria categoria = new Categoria();
            categoria.setId(Integer.parseInt(request.getParameter("categoria")));
            produto.setCategoria(categoria);
            produto.setDescricao(request.getParameter("descricao"));
            produto.setCodigo_barra(Long.parseLong(request.getParameter("codbarras")));
            produto.setPreco_custo(Double.parseDouble(request.getParameter("pcusto")));
            produto.setPreco_venda(Double.parseDouble(request.getParameter("pVenda")));
            produto.setQtdcompra(Integer.parseInt(request.getParameter("qtdCompra")));
            produto.setQtdminima(Integer.parseInt(request.getParameter("qtdMinima")));
            if (cadProDAO.cadastrarProduto(produto) == true) {
                request.setAttribute("msg", "Produto cadastrado com sucesso!!!");
                request.getRequestDispatcher("produtosCadastrar.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Ocorreu uma falha ao cadastrar o produto!!!");
                request.getRequestDispatcher("produtosCadastrar.jsp").forward(request, response);
            }
        } else if (request.getParameter("botao").equals("ADICIONAR")) {
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
