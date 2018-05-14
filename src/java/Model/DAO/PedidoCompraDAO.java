/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Fornecedor;
import Model.PedidodeCompra;
import Model.Produto;
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
public class PedidoCompraDAO {

    private static final String LISTA_PED_COMP = "SELECT p.id, f.nome, p.totalPedido, p.dataPedido, p.status FROM pedidoDeCompra p, fornecedor f WHERE p.fornecedor = f.id and p.fornecedor = ? ORDER BY p.dataPedido";
    private static final String CHECK_PEDIDO = "SELECT * FROM pedidodecompra WHERE fornecedor = ? AND status = ?";
    private static final String INS_PEDIDO = "INSERT INTO pedidodecompra (id, fornecedor, datapedido, status) VALUES (DEFAULT, ?, CURRENT_TIMESTAMP, ?) returning id";
    private static final String ATUALIZA_PEDIDO = "UPDATE pedidodecompra SET totalpedido = totalpedido + (SELECT valor FROM itemdecompra WHERE id = ?) WHERE id = ?";
    private static final String ENVIA_PEDIDO = "UPDATE pedidodecompra SET status = ? WHERE id = ?";
    public List<PedidodeCompra> consultaPedidos(int fornecedor) {
        try {

            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_PED_COMP);
            pstmt.setInt(1, fornecedor);
            ResultSet rs = pstmt.executeQuery();
            List<PedidodeCompra> listapedido = new ArrayList<>();
            while (rs.next()) {
                PedidodeCompra pedido = new PedidodeCompra();
                pedido.setId(rs.getInt("id"));
                Fornecedor fornecedors = new Fornecedor();
                fornecedors.setNome(rs.getString("nome"));
                pedido.setFornecedor(fornecedors);
                pedido.setTotal_pedido(rs.getDouble("totalPedido"));
                pedido.setData_pedido(rs.getDate("dataPedido"));
                pedido.setStatus(rs.getString("status"));
                listapedido.add(pedido);
            }
            pstmt.close();
            conexao.close();
            return listapedido;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int criaPedido(Produto produto) {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INS_PEDIDO);
            pstmt.setInt(1, produto.getFornecedor().getId());
            pstmt.setString(2, "EM_ABERTO");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int idPedido = rs.getInt("id");
            return idPedido;
        } catch (Exception e) {
            return 0;
        }

    }

    public int checaPedido(Produto produto) {
        try {
            int retorno = 0;
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(CHECK_PEDIDO);
            pstmt.setInt(1, produto.getFornecedor().getId());
            pstmt.setString(2, "EM_ABERTO");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            retorno = rs.getInt("id");
            return retorno;
        } catch (Exception e) {
            return 0;
        }

    }

    public void atualizavalor(int numeropedido, int numeroitem) {

        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(ATUALIZA_PEDIDO);
            pstmt.setInt (1, numeroitem);
            pstmt.setInt (2, numeropedido);
            pstmt.execute();
            pstmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            SQLException erro = e;
            System.out.println("nao passou");
        }
    }

    public void mudarStatus(int pedido) {
        try{
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(ENVIA_PEDIDO);
            pstmt.setString (1, "ENVIADO");
            pstmt.setInt (2, pedido);
            pstmt.execute();
            pstmt.close();
            conexao.close();
        }catch (Exception e){
            
        }
    }

}
