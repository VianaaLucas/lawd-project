/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.DAO.ConectaBanco;
import Model.Desconto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre.albuquerque
 */
public class DescontoDAO {

    public static final String INSERIR_DESCONTO = "INSERT INTO desconto (categoria, percentualdesconto, ativo) VALUES (?, ?, true)";
    public static final String CHECADESCONTO = "SELECT * FROM desconto WHERE categoria = ? AND ativo = true";
    public static final String VERIFICADESCONTO = "SELECT * FROM desconto WHERE categoria = ? AND ativo = true";
    public static final String INATIVADESCONTO = "UPDATE desconto SET ativo = FALSE WHERE categoria = ?";

    public boolean desconto(Desconto desconto) {
        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(INSERIR_DESCONTO);
            stmt.setDouble(2, desconto.getPercentualDeDesconto());
            stmt.setInt(1, desconto.getCategoria().getId());
            stmt.execute();
            conexao.close();
            return true;
        } catch (SQLException erro1) {
            return false;
        }
    }

    public Double verificaDesconto(Double preco, int cat) {
        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(VERIFICADESCONTO);
            stmt.setInt(1, cat);
            ResultSet resultado = stmt.executeQuery();
            Double precofinal = 0.0;
            while (resultado.next()) {
                precofinal = preco - preco / 100 * resultado.getDouble("percentualdesconto");
            }
            stmt.close();
            conexao.close();
            return precofinal;
        } catch (SQLException e) {
            return null;
        }
    }

    public double checaDesconto(Desconto desconto) {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(CHECADESCONTO);
            stmt.setInt(1, desconto.getCategoria().getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("percentualDesconto");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            return 0;
        }
    }

    public boolean inativaDesconto(Desconto desconto) {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(INATIVADESCONTO);
            stmt.setInt(1, desconto.getCategoria().getId());
            stmt.execute();
            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException erro1) {
            return false;
        }
    }

}
