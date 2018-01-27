package Model.DAO;

import Model.Estado;
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
public class EstadoDAO {

    public static final String LISTA_TODOS = "Select * from estado";

    public List<Estado> lista() throws SQLException {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_TODOS);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Estado> listaEstados = new ArrayList<>();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                listaEstados.add(estado);
            }
            conexao.close();
            return listaEstados;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
