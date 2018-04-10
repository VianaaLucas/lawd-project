package Model;

public class Produto {

    private int id;

    private String descricao;

    private long codigo_barra;

    private double preco_custo;

    private double preco_venda;
    
    private int qtdminima;
    
    private int qtdcompra;

    private int quantidade_estoque;

    private Categoria categoria;

    private SubCategoria subCategoria;

    private Fornecedor fornecedor;

    public int getQtdminima() {
        return qtdminima;
    }

    public void setQtdminima(int qtdminima) {
        this.qtdminima = qtdminima;
    }

    public int getQtdcompra() {
        return qtdcompra;
    }

    public void setQtdcompra(int qtdcompra) {
        this.qtdcompra = qtdcompra;
    }
    
    public Produto(long codigo) {
        this.codigo_barra = codigo;
    }

    public Produto() {
    }

    public void add_categoria() {

    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(long codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

}
