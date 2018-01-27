package Model.DAO;

import Model.Cidade;
import Model.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {

    public static final String LISTA_TODOS = "Select * from Cidade";

    public List<Cidade> lista() throws SQLException {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_TODOS);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Cidade> listaCidades = new ArrayList<>();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("descricao"));
                listaCidades.add(cidade);
            }

            return listaCidades;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static final String LISTA_PARA_ESTADO = "SELECT * FROM cidade WHERE estado = ?";

    public List<Cidade> listaParaEstado (Estado estado) {
        try {

            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_PARA_ESTADO);
            pstmt.setInt(1, estado.getId());
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Cidade> listaCidades = new ArrayList < > ();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setEstado(new Estado(estado.getId()));
                cidade.setNome(rs.getString("nome"));
                listaCidades.add(cidade);
            }
            return listaCidades;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
