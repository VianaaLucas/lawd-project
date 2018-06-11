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
                PreparedStatement stmt = conexao.prepareStatement("select sum (valor_total) from pedido where data_pedido between '2018-" + x + "-01' and (date '2018-" + x + "-01' +interval '1 month') AND status = 'FECHADO'");
                ResultSet rs = stmt.executeQuery();
                rs.next();
                lista.add(rs.getDouble("sum"));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Double> relatoriodeestoque() {

        return null;
    }

    public ArrayList<ArrayList<Double>> relatoriodepagamentos() {
        ArrayList<ArrayList<Double>> retorno = new ArrayList<>();
        ArrayList<Double> lista = new ArrayList<>();
        ArrayList<Double> lista2 = new ArrayList<>();
        ArrayList<Double> lista3 = new ArrayList<>();
        Connection conexao = ConectaBanco.getConexao();
        PreparedStatement stmt = null;
        try {
            for (int x = 1; x <= 12; x++) {
                stmt = conexao.prepareStatement("select sum (quantia) from pagamento where data_pag between '2018-" + x + "-01' and (date '2018-" + x + "-01' +interval '1 month') AND status = 'OK' AND metodo = 'DINHEIRO'");
                ResultSet rs = stmt.executeQuery();
                rs.next();
                lista.add(rs.getDouble("sum"));
                System.out.println("passou");
            }
            retorno.add(lista);
            for (int x = 1; x <= 12; x++) {
                stmt = conexao.prepareStatement("select sum (quantia) from pagamento where data_pag between '2018-" + x + "-01' and (date '2018-" + x + "-01' +interval '1 month') AND status = 'OK' AND metodo = 'CARTAO_CREDITO'");
                ResultSet rs = stmt.executeQuery();
                rs.next();
                lista2.add(rs.getDouble("sum"));
                System.out.println("passou");
            }
            retorno.add(lista2);
            for (int x = 1; x <= 12; x++) {
                stmt = conexao.prepareStatement("select sum (quantia) from pagamento where data_pag between '2018-" + x + "-01' and (date '2018-" + x + "-01' +interval '1 month') AND status = 'OK' AND metodo = 'CARTAO_DEBITO'");
                ResultSet rs = stmt.executeQuery();
                rs.next();
                lista3.add(rs.getDouble("sum"));
                System.out.println("passou");
            }
            retorno.add(lista3);
            conexao.close();
            stmt.close();
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }
}
