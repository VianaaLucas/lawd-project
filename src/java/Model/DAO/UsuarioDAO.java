/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

/**
 *
 * @author hataishi
 * @author Lucas Viana
 */
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.PerfilDeAcesso;

public class UsuarioDAO {

    private static final String CADASTRA_NOVO_USUARIO = "INSERT INTO users(usuario, senha, perfil) VALUES(?,crypt(?, gen_salt('bf',8)),?)";
    private static final String AUTENTICA_USUARIO = "SELECT * FROM users WHERE usuario=? and senha = crypt(?, senha)";

    public void cadastraNovoUsuario(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(CADASTRA_NOVO_USUARIO);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getPerfil().toString());
            pstmt.execute();
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public Usuario autenticaUsuario(Usuario usuario) throws SQLException {
        Usuario usuarioAutenticado = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsUsuario = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICA_USUARIO);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getSenha());
            rsUsuario = pstmt.executeQuery();

            if (rsUsuario.next()) {
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setUsuario(rsUsuario.getString("Usuario"));
                usuarioAutenticado.setSenha(rsUsuario.getString("Senha"));
                usuarioAutenticado.setPerfil(PerfilDeAcesso.valueOf(rsUsuario.getString("perfil")));
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return usuarioAutenticado;
    }
}
