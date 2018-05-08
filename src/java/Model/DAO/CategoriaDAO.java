package Model.DAO;

import java.sql.SQLException;
import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class CategoriaDAO {

    private static final String LISTA_TODOS = "SELECT * FROM categoria order by nome asc";

    public ArrayList<Categoria> lista() {
        try {

            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_TODOS);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Categoria> listaCategorias = new ArrayList<>();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                listaCategorias.add(categoria);
            }

            return listaCategorias;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean Consultar(Categoria cat) throws SQLException {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("select * from categoria where nome = ?");
            stmt.setString(1, cat.getNome());

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
//                lista = List<categoria>;
            }

            conexao.close();
            retorno = true;
        } catch (SQLException erro1) {
            retorno = false;
        }
        return retorno;
    }

    public Categoria buscarPorId(Categoria c) throws SQLException {

        Connection con = ConectaBanco.getConexao();
        String sql = "SELECT * FROM categoria WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, c.getId());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            c.setNome(rs.getString("nome"));
        }

        return c;
    }
    
    public boolean Cadastrar(Categoria cat) throws SQLException {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("insert into categoria (id, nome) values (DEFAULT, ?) ");
            stmt.setString(1, cat.getNome());
            stmt.execute(); 
            conexao.close();
            
            retorno = true;
        } catch (Exception erro1) {
            retorno = false;
        }

        return retorno;
    }
    
    
//método da classe antiga --archive--
//    public List<Categoria> lista(){
//        try{
//            
//            Connection conexao = ConectaBanco.getConexao();
//            PreparedStatement pstmt = conexao.prepareStatement(LISTA_TODOS);
//            
//            ResultSet rs = pstmt.executeQuery();
//            
//            List<Categoria> listaCats = new ArrayList<>();
//            while(rs.next()){
//                Categoria categoria = new Categoria();
//                categoria.setId(rs.getInt("id"));
//                categoria.setNome(rs.getString("nome"));
//                listaCats.add(categoria);
//            }
//            
//            return listaCats;
//            
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
}
