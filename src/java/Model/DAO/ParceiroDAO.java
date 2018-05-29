package Model.DAO;

import Model.ClienteFisico;
import Model.ClienteJuridico;
import Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParceiroDAO {

    private static final String LISTA_TODOS = "SELECT id, nome FROM fornecedor ORDER BY nome";
    public ArrayList<Fornecedor> lista() {
        try {

            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTA_TODOS);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Fornecedor> listaCategorias = new ArrayList<>();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                listaCategorias.add(fornecedor);
            }

            return listaCategorias;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean cadastrarClienteJuridico(ClienteJuridico cliente) {
        Connection conexao = null;
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cliente(nome, telefone, celular, email, cep, numero, complemento, rua, cidade, estado, tipo, cnpj, ie, razao_social) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCelular());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getEndereco().getCep());
            stmt.setInt(6, cliente.getEndereco().getNumero());
            stmt.setString(7, cliente.getEndereco().getComplemento());
            stmt.setString(8, cliente.getEndereco().getRua());
            stmt.setInt(9, cliente.getEndereco().getCidade().getId());
            stmt.setInt(10, cliente.getEndereco().getEstado().getId());
            stmt.setInt(11, 1);
            stmt.setString(12, cliente.getCnpj());
            stmt.setString(13, cliente.getIe());
            stmt.setString(14, cliente.getRazao_social());
            stmt.execute();
            conexao.close();
            return true;
        } catch (SQLException erro1) {

            return false;
        }
    }

    public boolean cadastrarClienteFisico(ClienteFisico cliente) {
        Connection conexao = null;
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO cliente(nome, telefone, celular, email, cep, numero, complemento, rua, cidade, estado, tipo, rg, cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getCelular());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getEndereco().getCep());
            stmt.setInt(6, cliente.getEndereco().getNumero());
            stmt.setString(7, cliente.getEndereco().getComplemento());
            stmt.setString(8, cliente.getEndereco().getRua());
            stmt.setInt(9, cliente.getEndereco().getCidade().getId());
            stmt.setInt(10, cliente.getEndereco().getEstado().getId());
            stmt.setInt(11, 2);
            stmt.setString(12, cliente.getRg());
            stmt.setString(13, cliente.getCpf());
            stmt.execute();
            conexao.close();
            return true;
        } catch (SQLException erro1) {
            return false;
        }
    }

    public boolean cadastrarFornecedor(Fornecedor fornecedor) {
        try {

            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO fornecedor (nome, telefone, celular, email, cep, numero, complemento, rua, cidade, estado, cnpj, ie, razao_social, pedido_minimo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getCelular());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setInt(5, fornecedor.getEndereco().getCep());
            stmt.setInt(6, fornecedor.getEndereco().getNumero());
            stmt.setString(7, fornecedor.getEndereco().getComplemento());
            stmt.setString(8, fornecedor.getEndereco().getRua());
            stmt.setInt(9, fornecedor.getEndereco().getCidade().getId());
            stmt.setInt(10, fornecedor.getEndereco().getEstado().getId());
            stmt.setString(11, fornecedor.getCnpj());
            stmt.setString(12, fornecedor.getIe());
            stmt.setString(13, fornecedor.getRazao_social());
            stmt.setDouble(14, fornecedor.getPedido_minimo());
            stmt.execute();
            conexao.close();

            return true;
        } catch (SQLException erro1) {
            return false;
        }
    }

    
}
