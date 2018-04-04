/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */

public class PagamentoDAO {

    Connection conexao = null;
    PreparedStatement pstmt = null;
    private static final String INSERTPAG = "INSERT INTO pagamento (id, metodo, data_pag, status, pedido, quantia) VALUES (DEFAULT, ?, CURRENT_TIMESTAMP, ?, ?, ?) returning id";
    private static final String CANCELAPAG = "UPDATE pagamento SET status = ? WHERE id = ?";

    public boolean cancelaPag(Pagamento pagamento) {
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(CANCELAPAG);
            pstmt.setString(1, "CANCELADO");
            pstmt.setInt(2, pagamento.getId());
            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public int gravarPagamento(Pagamento pagamento) {
        int idPedido = 0;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(INSERTPAG);
            pstmt.setString(1, pagamento.getTipo_pag());
            pstmt.setString(2, "OK");
            pstmt.setInt(3, pagamento.getId_Pedido());
            pstmt.setDouble(4, pagamento.getQuantia());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            idPedido = rs.getInt("id");
        } catch (SQLException e) {
            return 0;
        }
        return idPedido;
    }

}
