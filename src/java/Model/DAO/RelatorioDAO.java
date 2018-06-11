package Model.DAO;

import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class RelatorioDAO {

    private static final String REPORTVENDAS = "";

    public ArrayList<Double> relatoriodevendas() {
        ArrayList<Double> lista = new ArrayList<>();
        try {
            for (int x = 1; x <= 12; x++) {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement("select sum (valor_total) from pedido where data_pedido between '2018-"+x+"-01' and (date '2018-"+x+"-01' +interval '1 month') AND status = 'FECHADO'");
            
                String aux = "" + x;
                //stmt.setString(1, "2018-"+aux+"-01");
                //stmt.setString(2, "2018-"+aux+"-01");
                ResultSet rs = stmt.executeQuery();
                rs.next(); 
                lista.add(rs.getDouble("sum"));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
}
