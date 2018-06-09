 package Control;

import Model.Pedido;
import Model.ItemDeCompra;
import Model.DAO.PedidoDAO;
import Model.DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lucas
 */
public class ControleCarrinho extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String acao = request.getParameter("acao");
            if (acao.equals("addProduto")) {
                //recupera o id do produto que deve ser add no carrinho
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                //flag para controle de inserção de novos produtos no carrinho
                boolean existe = false;
                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
                //recupera um carrinho de produtos da sessão
                //se não exite um carrinho na sessão o valor será igual a null
                Pedido carrinho = (Pedido) sessao.getAttribute("carrinho");
                //verifica se já exista um carrinho na sessao
                if (carrinho == null) {
                    //cria um carrinho 
                    carrinho = new Pedido();
                    sessao.setAttribute("carrinho", carrinho);
                }
                //verifica se o produto existe no carrinho
                if (carrinho.getItens() != null) {
                    for (ItemDeCompra item : carrinho.getItens()) {
                        if (item.getProduto().getId() == idProduto) {
                            //incrementa a quantidade
                            item.setQuantidade(item.getQuantidade() + 1);
                            existe = true;
                        }
                    }
                }
                //se não existe o item ou produto, cria um novo
                if (existe == false) {
                    //encontra o produto no banco
                    Produto produto = new ProdutoDAO().consultarPorCodbar(idProduto);
                    //cria um novo item
                    ItemDeCompra novoItem = new ItemDeCompra();
                    novoItem.setProduto(produto);
                    novoItem.setQuantidade(1);
                    //adiciona novo item
                    carrinho.addNovoItem(novoItem);
                }
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/pdv.jsp").forward(request, response);
            }//fim addProduto
            else if (acao.equals("removeProduto")) {
                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
                //recupera um carrinho de produtos da sessão
                Pedido carrinho = (Pedido) sessao.getAttribute("carrinho");
                //recupera o id do produto
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                ItemDeCompra itemRemove = new ItemDeCompra();
                Produto prodRemove = new Produto();
                prodRemove.setId(idProduto);
                itemRemove.setProduto(prodRemove);
                carrinho.removerItem(itemRemove);
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/pdv.jsp").forward(request, response);
            } else if (acao.equals("cancelaCompra")) {
                //recupera a sessão pertencente ao request
                HttpSession sessao = request.getSession();
                //remove o carrinho da sessão
                sessao.removeAttribute("carrinho");
                //redireciona para pagina principal
                response.sendRedirect("pdv.jsp");
            }
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
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
        if (botao.equals("INSERIR")) {
            //recupera o codigo do produto que deve ser add no carrinho
            long codigo = Long.parseLong(request.getParameter("codigo"));
            //flag para controle de inserção de novos produtos no carrinho
            boolean existe = false;
            //recupera a sessão pertencente ao request
            HttpSession sessao = request.getSession();
            //recupera um carrinho de produtos da sessão
            //se não exite um carrinho na sessão o valor será igual a null
            Pedido carrinho = (Pedido) sessao.getAttribute("carrinho");
            //verifica se já exista um carrinho na sessao
            if (carrinho == null) {
                //cria um carrinho 
                carrinho = new Pedido();
                sessao.setAttribute("carrinho", carrinho);
            }
            //verifica se o produto existe no carrinho
            if (carrinho.getItens() != null) {
                for (ItemDeCompra item : carrinho.getItens()) {
                    if (item.getProduto().getCodigo_barra() == codigo) {
                        //incrementa a quantidade
                        item.setQuantidade(item.getQuantidade() + 1);
                        existe = true;
                    }
                }
            }
            //se não existe o item ou produto, cria um novo
            if (existe == false) {
                //encontra o produto no banco
                Produto produto = new ProdutoDAO().consultarPorCodbar(codigo);
                //cria um novo item
                ItemDeCompra novoItem = new ItemDeCompra();
                novoItem.setProduto(produto);
                novoItem.setQuantidade(1);
                if (novoItem.getProduto().getDescricao() != null) {
                    //adiciona novo item
                    carrinho.addNovoItem(novoItem);
                }
            }
            request.getRequestDispatcher("/pdv.jsp").forward(request, response);
            //carrega a pagina do carrinho de compras
        } else if (botao.equals("CANCELAR")) {
            //recupera a sessão pertencente ao request
            HttpSession sessao = request.getSession();
            //remove o carrinho da sessão
            sessao.removeAttribute("carrinho");
            response.sendRedirect("pdv.jsp");
        } else if (botao.equals("FINALIZAR")) {
            //Grava os itens e o pedido no banco de dados e efetua a baixa no estoque
            HttpSession sessao = request.getSession();
            Pedido carrinho = (Pedido) sessao.getAttribute("carrinho");
            PedidoDAO pedido = new PedidoDAO();
            int idPedido = 0;
            idPedido = pedido.gravaPedidos(carrinho);
            if (idPedido > 0) {
                //nota
                carrinho.setId(idPedido);
                sessao.setAttribute("carrinho", carrinho);
                request.getRequestDispatcher("/pagamento.jsp").forward(request, response);
            }
        } else if (botao.equals("ENCERRAR")) {
            //encerra a sessão e abre a pagina home
            HttpSession sessao = request.getSession();
            Pedido carrinho = (Pedido) sessao.getAttribute("carrinho");
            sessao.removeAttribute("carrinho");
            response.sendRedirect("home.jsp");
            
        } else if (botao.equals("FINALIZARPEDIDO")) {
            HttpSession sessao = request.getSession();
            PedidoDAO pedido = new PedidoDAO();
            Pedido carrinho = (Pedido) sessao.getAttribute("carrinho");
            pedido.fechaPedido(carrinho.getId());
            sessao.removeAttribute("carrinho");
            sessao.removeAttribute("idPedido");
            response.sendRedirect("pdv.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}