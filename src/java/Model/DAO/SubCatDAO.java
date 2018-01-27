/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Categoria;
import Model.SubCategoria;
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
public class SubCatDAO {

    private static final String LISTA_PARA_CATEGORIA = "SELECT * FROM subcategoria WHERE id_cat=? order by nome asc";

    public List<SubCategoria> listaParaCategoria(Categoria categoria) {
        try {

            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_PARA_CATEGORIA);
            pstmt.setInt(1, categoria.getId());
            ResultSet rs = pstmt.executeQuery();

            ArrayList<SubCategoria> listaSubCategoria = new ArrayList<>();
            while (rs.next()) {
                SubCategoria subCategoria = new SubCategoria();
                subCategoria.setId(rs.getInt("id"));
                subCategoria.setCategoria(rs.getInt("id"));
                subCategoria.setNome(rs.getString("nome"));
                listaSubCategoria.add(subCategoria);
            }

            return listaSubCategoria;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean cadastrar(SubCategoria subcat) {

        boolean retorno = true;
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("insert into subcategoria (id_cat, nome) values(?,?) ");
            int cat = subcat.getCategoria();
            String name = subcat.getNome();
            
            stmt.setInt(1, cat);
            stmt.setString(2, name);
            
            stmt.execute();

            conexao.close();

            retorno = true;
        } catch (SQLException erro1) {
            retorno = false;
        }

        return retorno;
    }
}

