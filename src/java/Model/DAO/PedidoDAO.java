/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.CarrinhoDeCompra;
import Model.ItemDeCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class PedidoDAO {

    private static final String INSERTPED = "INSERT INTO pedido(id, data_pedido, valor_total, status) VALUES (DEFAULT, CURRENT_TIMESTAMP, ?, ?) returning id";
    private static final String INSERTITEM = "INSERT INTO public.itempedido(id_pedido, codigo_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
    private static final String BAIXAESTOQUE = "UPDATE produto SET estoque = (SELECT estoque FROM produto WHERE id = ?) - ? where id = ?";
    private static final String FECHAPED = "UPDATE pedido SET status = ? WHERE id = ?";
    private static final String TESTCSVLISTAR = "SELECT * FROM pedido";

    public int gravaPedidos(CarrinhoDeCompra carrinho) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(INSERTPED);
            pstmt.setDouble(1, carrinho.getTotal());
            pstmt.setString(2, "EM_ABERTO");
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
            return idPedido;
        } catch (Exception e) {
            return 0;
        }

    }

    public void fechaPedido(int idPedido) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(FECHAPED);
            pstmt.setString(1, "FECHADO");
            pstmt.setInt(2, idPedido);
            pstmt.execute();
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("NÃO PASSOU");
        }
        System.out.println("PASSOU");
    }
    
    public List<String> testCsvTest() throws Exception {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        conexao = ConectaBanco.getConexao();
        pstmt = conexao.prepareStatement(TESTCSVLISTAR);
        
        rs = pstmt.executeQuery();
        List<String> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(String.valueOf(rs.getInt("id")));
            lista.add(String.valueOf(rs.getDate("data_pedido")));
            lista.add(String.valueOf(rs.getDouble("valor_total")));
            lista.add(String.valueOf(rs.getString("status")));
        }
        
        return lista;
    }
}
