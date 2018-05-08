package Model.DAO;

import Model.ItemDeCompra;
import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lucas
 */
public class ItemDeCompraDAO {

    private static final String INSERTITEM      = "INSERT INTO public.itempedido(id_pedido, codigo_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
    
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
}
