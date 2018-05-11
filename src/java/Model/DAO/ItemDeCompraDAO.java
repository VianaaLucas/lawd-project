package Model.DAO;

import Model.ItemDeCompra;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lucas
 */
public class ItemDeCompraDAO {

    private static final String INSERTITEM = "INSERT INTO public.itempedido(id_pedido, codigo_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
    private static final String INSERTITEMPED = "INSERT INTO itemdecompra (id, produto, quantidade, pedidocompra, valor) VALUES (DEFAULT, ?, ?, ?, ?) returning id";

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

    public int gravarItemCompra(int idPedido, ItemDeCompra item, Produto produto) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(INSERTITEMPED);
            pstmt.setInt(1, item.getProduto().getId());
            pstmt.setInt(2, produto.getQtdcompra());
            pstmt.setInt(3, idPedido);
            pstmt.setDouble(4, (produto.getQtdcompra() * produto.getPreco_custo()));
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            return 0;
        }

    }
}
