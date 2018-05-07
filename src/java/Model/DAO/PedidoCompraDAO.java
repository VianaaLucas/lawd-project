/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Fornecedor;
import Model.PedidodeCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class PedidoCompraDAO {
    private static final String LISTA_PED_COMP = "SELECT p.id, f.nome, p.totalPedido, p.dataPedido, p.status FROM pedidoDeCompra p, fornecedor f WHERE p.fornecedor = f.id and p.fornecedor = ? ORDER BY p.dataPedido";
    
   public List<PedidodeCompra> consultaPedidos(int fornecedor){
        try{
            
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_PED_COMP);
            pstmt.setInt(1, fornecedor);
            ResultSet rs = pstmt.executeQuery();
            
            List<PedidodeCompra> listapedido = new ArrayList<>();
            while(rs.next()){
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
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
