/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Pedido;
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
 *
 */
public class PedidoDAO {

    private static final String INSERTPED = "INSERT INTO pedido(id, data_pedido, valor_total, status) VALUES (DEFAULT, CURRENT_TIMESTAMP, ?, ?) returning id";
    private static final String FECHAPED = "UPDATE pedido SET status = ? WHERE id = ?";
    private static final String TESTCSVLISTAR = "SELECT * FROM pedido";

    public int gravaPedidos(Pedido carrinho) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            ItemDeCompraDAO idcDAO = new ItemDeCompraDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
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
                idcDAO.gravarItem(idPedido, item);
                produtoDAO.baixarEstoque(item);
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

        while (rs.next()) {
            lista.add(String.valueOf(rs.getInt("id")));
            lista.add(String.valueOf(rs.getDate("data_pedido")));
            lista.add(String.valueOf(rs.getDouble("valor_total")));
            lista.add(String.valueOf(rs.getString("status")));
        }

        return lista;
    }
}
