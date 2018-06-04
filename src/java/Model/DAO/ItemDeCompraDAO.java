package Model.DAO;

import Model.ItemDeCompra;
import Model.PedidodeCompra;
import Model.Produto;
import static com.sun.javafx.fxml.expression.Expression.and;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javafx.beans.binding.Bindings.and;
import static javax.management.Query.and;

/**
 *
 * @author lucas
 */
public class ItemDeCompraDAO {

    private static final String INSERTITEM = "INSERT INTO public.itempedido(id_pedido, codigo_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
    private static final String INSERTITEMPED = "INSERT INTO itemdecompra (id, produto, quantidade, pedidocompra, valor) VALUES (DEFAULT, ?, ?, ?, ?) returning id";
    private static final String CONSULTAITENS = "SELECT * FROM itemdecompra WHERE pedidocompra = ?";
    private static final String CHECKITEMPED = "SELECT * FROM itemdecompra WHERE produto = ? AND pedidocompra = ?";
    private static final String UPDITEMPED = "UPDATE itemdecompra SET quantidade = ?, valor = ? WHERE pedidocompra = ? AND produto = ? returning id";
    private static final String CALCULATOTAL = "SELECT SUM(valor) from itemdecompra WHERE pedidocompra = ?";
    
    public boolean gravarItem(int idPedido, ItemDeCompra item) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(INSERTITEM);
            pstmt.setInt(1, idPedido);
            pstmt.setInt(2, item.getProduto().getId());
            pstmt.setInt(3, item.getQuantidade());
            pstmt.setDouble(4, item.getProduto().getPreco_venda());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public int gravarItemCompra(int idPedido, ItemDeCompra item, Produto produto) throws SQLException {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(CHECKITEMPED);
            pstmt.setInt(1, item.getProduto().getId());
            pstmt.setInt(2, idPedido);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int qtdEstoque = 0;
                    if (produto.getQuantidade_estoque() < 0) {
                        qtdEstoque = Math.abs(produto.getQuantidade_estoque());
                    } else {
                        qtdEstoque = produto.getQuantidade_estoque();
                    }
                    int x = Math.round((produto.getQtdminima() + qtdEstoque));
                    int c = 0;
                    while (c <= x) {
                        c = c + produto.getQtdcompra();
                    }
                    pstmt = conexao.prepareStatement(UPDITEMPED);
                    pstmt.setInt(1, c);
                    pstmt.setDouble(2, (c * produto.getPreco_custo()));
                    pstmt.setInt(3, idPedido);
                    pstmt.setInt(4, produto.getId());
                    ResultSet ra = pstmt.executeQuery();
                    ra.next();
                    return rs.getInt("pedidocompra");
            } else {
                try {
                    int qtdEstoque = 0;
                    if (produto.getQuantidade_estoque() < 0) {
                        qtdEstoque = Math.abs(produto.getQuantidade_estoque());
                    } else {
                        qtdEstoque = produto.getQuantidade_estoque();
                    }
                    int x = Math.round((produto.getQtdminima() + qtdEstoque));
                    int c = 0;
                    while (c <= x) {
                        c = c + produto.getQtdcompra();
                    }
                    pstmt = conexao.prepareStatement(INSERTITEMPED);
                    pstmt.setInt(1, item.getProduto().getId());
                    pstmt.setInt(2, c);
                    pstmt.setInt(3, idPedido);
                    pstmt.setDouble(4, (produto.getQtdcompra() * produto.getPreco_custo()));
                    ResultSet rb = pstmt.executeQuery();
                    rb.next();
                    return rs.getInt("pedidocompra");
                } catch (Exception e) {
                    return 0;
                }

            }
        } catch (Exception e) {
            return 0;
        }
        
    }


public List<ItemDeCompra> consultaItemPedido(PedidodeCompra pedido) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(CONSULTAITENS);
            pstmt.setInt(1, pedido.getId());
            ResultSet rs = pstmt.executeQuery();
            ArrayList<ItemDeCompra> itens = new ArrayList<>();
            while (rs.next()) {
                ItemDeCompra item = new ItemDeCompra();
                Produto produto = new Produto();
                ProdutoDAO produtodao = new ProdutoDAO();
                produto = produtodao.consultaporid(rs.getInt("produto"));
                item.setProduto(produto);
                item.setQuantidade(rs.getInt("quantidade"));
                item.setId(rs.getInt("id"));
                itens.add(item);
            }
            return itens;
        } catch (Exception e) {
            return null;
        }

    }

public double calculaTotal (int ped){
   try{
       Connection conexao = ConectaBanco.getConexao();
       PreparedStatement stmt = conexao.prepareStatement(CALCULATOTAL);
       stmt.setInt (1, ped);
       ResultSet rs = stmt.executeQuery();
       rs.next();
       double retorno = rs.getDouble("sum");
       return retorno;
   }catch (Exception e){
       return 0;
   }
}
}
