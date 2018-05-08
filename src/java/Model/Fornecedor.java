package Model;

public class Fornecedor extends Pessoa {

    private int id;
    private String cnpj;
    private String ie;
    private String razao_social;
    private double pedido_minimo;
    
    public double getPedido_minimo() {
        return pedido_minimo;
    }

    public void setPedido_minimo(double pedido_minimo) {
        this.pedido_minimo = pedido_minimo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

}
