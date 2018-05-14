package Model;


public class ItemDeCompra {

    private int id;
    private Long codigo;
    private Produto produto;
    private int quantidade;
    private double total;

    public Long getCodigo() {
        return codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        this.total = this.quantidade * this.produto.getPreco_venda();
        return total;
    }

    public double getTotalCompra(){
        this.total = this.quantidade * this.produto.getPreco_custo();
        return total;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
