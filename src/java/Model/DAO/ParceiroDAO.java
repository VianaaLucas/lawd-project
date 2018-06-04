package Model.DAO;

import Model.Cidade;
import Model.ClienteFisico;
import Model.ClienteJuridico;
import Model.Endereco;
import Model.Estado;
import Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParceiroDAO {

    private static final String LISTA_TODOS = "SELECT id, nome FROM fornecedor ORDER BY nome";
    private static final String CONSULTAFORNECEDOR = "SELECT * FROM fornecedor WHERE id = ?";
    private static final String CADASTRAFORNECEDOR = "INSERT INTO fornecedor (nome, telefone, celular, email, cep, numero, complemento, rua, cidade, estado, cnpj, ie, razao_social, pedido_minimo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            PreparedStatement stmt = conexao.prepareStatement(CADASTRAFORNECEDOR);
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

    public Fornecedor consultaFornPorID(int id) {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(CONSULTAFORNECEDOR);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Fornecedor fornecedor = new Fornecedor();
            if (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setEmail(rs.getString("email"));
                Endereco endereco = new Endereco();
                endereco.setCep(rs.getInt("cep"));
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("cidade"));
                Estado estado = new Estado();
                estado.setId(rs.getInt("estado"));
                cidade.setEstado(estado);
                endereco.setCidade(cidade);
                endereco.setEstado(estado);
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setRua(rs.getString("rua"));
                fornecedor.setEndereco(endereco);
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIe(rs.getString("ie"));
                fornecedor.setRazao_social(rs.getString("razao_social"));
                fornecedor.setPedido_minimo(rs.getDouble("pedido_minimo"));
            }
            return fornecedor;
        } catch (SQLException erro) {
            return null;
        }

    }
}
