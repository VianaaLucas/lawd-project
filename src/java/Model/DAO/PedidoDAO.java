/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Control.CarrinhoDeCompra;
import Model.ItemDeCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lucas
 */
public class PedidoDAO {

    private static final String INSERTPED = "INSERT INTO pedido(id, data_pedido, valor_total, modopag) VALUES (DEFAULT, CURRENT_TIMESTAMP, ?, ?) returning id";
    private static final String INSERTITEM = "INSERT INTO public.itempedido(id_pedido, codigo_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
    private static final String BAIXAESTOQUE = "UPDATE produto SET estoque = (SELECT estoque FROM produto WHERE id = ?) - ? where id = ?";

    public boolean gravaPedidos(CarrinhoDeCompra carrinho, int modo) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(INSERTPED);
            pstmt.setDouble(1, carrinho.getTotal());
            pstmt.setInt(2, modo);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int idPedido = rs.getInt("id");
            pstmt.close();
            conexao.close();
            for (ItemDeCompra item : carrinho.getItens()) {
                conexao = ConectaBanco.getConexao();
                pstmt = conexao.prepareStatement(INSERTITEM);
                pstmt.setInt(1, idPedido);
                pstmt.setInt(2, item.getProduto().getId());
                pstmt.setInt(3, item.getQuantidade());
                pstmt.setDouble(4, item.getProduto().getPreco_venda());
                pstmt.execute();
                pstmt.close();
                pstmt = conexao.prepareStatement(BAIXAESTOQUE);
                pstmt.setInt(1, item.getProduto().getId());
                pstmt.setInt(2, item.getQuantidade());
                pstmt.setInt(3, item.getProduto().getId());
                pstmt.execute();
                pstmt.close();
                conexao.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
