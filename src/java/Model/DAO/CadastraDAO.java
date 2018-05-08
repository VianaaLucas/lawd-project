package Model.DAO;

import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastraDAO {

    private static final String LISTA_TODOS= "SELECT * FROM categoria";
    
    public List<Categoria> lista(){
        try{
            
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_TODOS);
            
            ResultSet rs = pstmt.executeQuery();
            
            List<Categoria> listaCats = new ArrayList<>();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                listaCats.add(categoria);
            }
            
            return listaCats;
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    
    public boolean Cadastrar(Categoria cat) throws SQLException {
        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("insert into categoria (nome) values(?) ");
            stmt.setString(1, cat.getNome());
            stmt.execute();
            conexao.close();
            
            retorno = true;
        } catch (SQLException erro1) {
            retorno = false;
        }

        return retorno;
    }
}
