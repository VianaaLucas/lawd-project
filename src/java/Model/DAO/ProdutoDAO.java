package Model.DAO;

import Model.Categoria;
import Model.DAO.ConectaBanco;
import Model.Desconto;
import Model.Fornecedor;
import Model.ItemDeCompra;
import java.sql.Connection;
import Model.Produto;
import Model.SubCategoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre.albuquerque
 * @author Lucas Viana
 */
public class ProdutoDAO {

    private static final String SELECTALL = "SELECT * FROM produto WHERE ativo = true";
    private static final String SELECTID = "SELECT * FROM produto WHERE id = ? and ativo = true";
    private static final String SELECTCD = "SELECT * FROM produto WHERE codbar = ? and ativo = true";
    private static final String ALTERPRD = "UPDATE produto SET descricao=?, precocusto=?, precovenda=?, categoria=?, subcat=?, fornecedor=?, codbar=?, qtdminima=?, qtdcompra=? WHERE codbar = ?";
    private static final String INATIVAPRD = "UPDATE produto SET ativo = false WHERE codbar = ?";
    private static final String INSERTPROD = "INSERT INTO produto(descricao,codbar,precocusto,precovenda,categoria,subcat,fornecedor, estoque, qtdminima, qtdcompra) VALUES (?, ?, ?, ?, ?, ?, ?, 0, ?, ?)";
    private static final String BAIXAESTOQUE = "UPDATE produto SET estoque = (SELECT estoque FROM produto WHERE id = ?) - ? where id = ?";
    private static final String VERIFICA_LUCRO = "SELECT descricao, precocusto, precovenda FROM produto WHERE categoria = ? AND ativo = true ORDER BY precovenda DESC limit 6";

    public boolean inativarProduto(Produto produto) {
        Connection conexao = null;

        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(INATIVAPRD);
            stmt.setLong(1, produto.getCodigo_barra());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean alteraProduto(Produto produto) {
        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(ALTERPRD);
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco_custo());
            stmt.setDouble(3, produto.getPreco_venda());
            stmt.setInt(4, produto.getCategoria().getId());
            stmt.setInt(5, produto.getSubCategoria().getId());
            stmt.setInt(6, produto.getFornecedor().getId());
            stmt.setLong(7, produto.getCodigo_barra());
            stmt.setInt(8, produto.getQtdminima());
            stmt.setInt(9, produto.getQtdcompra());
            stmt.setLong(10, produto.getCodigo_barra());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Lucas Viana
    public Produto consultarPorCodigo(Produto produto) {
        Connection conexao = null;
        try {
            Categoria categoria = new Categoria();
            Fornecedor fornecedor = new Fornecedor();
            SubCategoria subcategoria = new SubCategoria();
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(SELECTCD);
            stmt.setLong(1, produto.getCodigo_barra());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            categoria.setId(rs.getInt("categoria"));
            subcategoria.setId(rs.getInt("subcat"));
            fornecedor.setId(rs.getInt("fornecedor"));
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco_venda(rs.getDouble("precovenda"));
            produto.setPreco_custo(rs.getDouble("precocusto"));
            produto.setCategoria(categoria);
            produto.setFornecedor(fornecedor);
            produto.setQuantidade_estoque(rs.getInt("estoque"));
            produto.setSubCategoria(subcategoria);
            produto.setCodigo_barra(rs.getLong("codbar"));
            produto.setQtdcompra(rs.getInt("qtdcompra"));
            produto.setQtdminima(rs.getInt("qtdminima"));
            rs.close();
            stmt.close();
            conexao.close();
            return produto;

        } catch (Exception e) {
            Exception erro = e;
            return null;
        }
    }

    public boolean cadastrarProduto(Produto produto) {

        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(INSERTPROD);
            stmt.setString(1, produto.getDescricao());
            stmt.setLong(2, produto.getCodigo_barra());
            stmt.setDouble(3, produto.getPreco_custo());
            stmt.setDouble(4, produto.getPreco_venda());
            stmt.setInt(5, produto.getCategoria().getId());
            stmt.setInt(6, produto.getSubCategoria().getId());
            stmt.setInt(7, produto.getFornecedor().getId());
            stmt.setInt(8, produto.getQtdminima());
            stmt.setInt(9, produto.getQtdcompra());
            stmt.execute();
            conexao.close();
            return true;
        } catch (Exception erro1) {
            return false;
        }

    }

    public ArrayList<Produto> consultarProdutoPorCodigo(Produto produto) throws SQLException {
        Connection conexao = null;

        try {
            long codigo = produto.getCodigo_barra();
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement("SELECT descricao, precovenda FROM produto WHERE codbar = ?");
            stmt.setLong(1, codigo);
            ResultSet rs = stmt.executeQuery();
            Desconto desconto = new Desconto();
            ArrayList<Produto> arrayproduto = new ArrayList<>();
            while (rs.next()) {
                produto.setCodigo_barra(codigo);
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco_venda(rs.getDouble("precovenda"));
//                produto.setPreco_venda(rs.getDouble("precovenda"));
                arrayproduto.add(produto);
            }
            rs.close();
            stmt.close();
            conexao.close();
            return arrayproduto;

        } catch (Exception e) {
            Exception erro = e;
            return null;
        }

    }

    public ArrayList consultarProdutoPorDescricao(Produto produto) throws SQLException {
        Connection conexao = null;

        PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?%");
        stmt.setString(1, produto.getDescricao());
        ResultSet rs = stmt.executeQuery();

        ArrayList arrayProduto = new ArrayList();
        while (rs.next()) {
            produto.setCodigo_barra(rs.getInt("codbar"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco_venda(rs.getDouble("precovenda"));
            arrayProduto.add(arrayProduto);
        }
        rs.close();
        stmt.close();
        conexao.close();
        return arrayProduto;
    }

    public boolean realizaEntrada(Produto produto) throws SQLException {
        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement("UPDATE produto set estoque = (SELECT estoque FROM produto WHERE codbar = ?) + ? where codbar = ?");
            stmt.setLong(1, produto.getCodigo_barra());
            stmt.setInt(2, produto.getQuantidade_estoque());
            stmt.setLong(3, produto.getCodigo_barra());
            stmt.execute();
            conexao.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Produto> listar() {
        Connection conexao = null;
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECTALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco_venda(rs.getDouble("precovenda"));
                listaProduto.add(prod);
            }
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }

        }
        //retorna a lista
        return listaProduto;
    }

    public Produto consultarPorCodbar(long codigo) {
        Connection conexao = null;
        Produto produto = new Produto();
        try {
            DescontoDAO desconto = new DescontoDAO();
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECTCD);
            pstmt.setLong(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("descricao") != null) {
                    produto.setId(rs.getInt("id"));
                    produto.setCodigo_barra(rs.getLong("codbar"));
                    produto.setDescricao(rs.getString("descricao"));
                    Double desc = desconto.verificaDesconto(rs.getDouble("precovenda"), rs.getInt("categoria"));
                    if (desc != 0) {
                        produto.setPreco_venda(desc);
                    } else {
                        produto.setPreco_venda(rs.getDouble("precovenda"));
                    }

                } else {
                    return null;
                }
            }
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }
        }
        return produto;
    }

    public boolean baixarEstoque(ItemDeCompra item) {

        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(BAIXAESTOQUE);
            pstmt.setInt(1, item.getProduto().getId());
            pstmt.setInt(2, item.getQuantidade());
            pstmt.setInt(3, item.getProduto().getId());
            pstmt.execute();
            pstmt.close();
            conexao.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Produto consultaporid(int id) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(SELECTID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Produto produto = new Produto();
            Categoria categoria = new Categoria();
            Fornecedor fornecedor = new Fornecedor();
            SubCategoria subcategoria = new SubCategoria();
            categoria.setId(rs.getInt("categoria"));
            subcategoria.setId(rs.getInt("subcat"));
            fornecedor.setId(rs.getInt("fornecedor"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setCodigo_barra(rs.getLong("codbar"));
            produto.setPreco_venda(rs.getDouble("precovenda"));
            produto.setPreco_custo(rs.getDouble("precocusto"));
            produto.setQuantidade_estoque(rs.getInt("estoque"));
            produto.setCategoria(categoria);
            produto.setSubCategoria(subcategoria);
            produto.setFornecedor(fornecedor);
            produto.setQtdcompra(rs.getInt("qtdcompra"));
            produto.setQtdminima(rs.getInt("qtdminima"));
            return produto;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Desconto> verificaLucro(Desconto desconto) {
        try {
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(VERIFICA_LUCRO);
            stmt.setInt(1, desconto.getCategoria().getId());
            ResultSet rs = stmt.executeQuery();
            List<Desconto> listadesconto = new ArrayList<>();
            while (rs.next()) {
                double descontoaplicado = (rs.getDouble("precovenda") - ((rs.getDouble("precovenda") * (desconto.getPercentualDeDesconto()))/100));
                if (descontoaplicado < rs.getDouble("precocusto")) {
                    Produto produto = new Produto();
                    Desconto desc = new Desconto();
                    Categoria categoria = new Categoria();
                    categoria.setId(desconto.getCategoria().getId());
                    produto.setPreco_custo(rs.getDouble("precocusto"));
                    produto.setPreco_venda(rs.getDouble("precovenda"));
                    produto.setDescricao(rs.getString("descricao"));
                    desc.setProduto(produto);
                    desc.setPercentualDeDesconto(desconto.getPercentualDeDesconto());
                    desc.setPrecoComDesconto(descontoaplicado);
                    desc.setCategoria(categoria);
                    listadesconto.add(desc);
                }
            }
            if (listadesconto.isEmpty()){
                return null;
            } else return listadesconto;
        }catch (Exception e){
            return null;
        }
    }
}
