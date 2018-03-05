package Model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.util.List;

public class Pedido {

    private int id;

    private double valor_total;

    private double valor_dinheiro;

    private double valor_ccredito;

    private double valor_cdebito;

    private Date data;

    private List<ItemPedido> itensPedido;

    private ClienteJuridico cliente;

    private Funcionario funcionario;

    public double getValor_dinheiro() {
        return valor_dinheiro;
    }

    public void setValor_dinheiro(double valor_dinheiro) {
        this.valor_dinheiro = valor_dinheiro;
    }

    public double getValor_ccredito() {
        return valor_ccredito;
    }

    public void setValor_ccredito(double valor_ccredito) {
        this.valor_ccredito = valor_ccredito;
    }

    public double getValor_cdebito() {
        return valor_cdebito;
    }

    public void setValor_cdebito(double valor_cdebito) {
        this.valor_cdebito = valor_cdebito;
    }

    public void add_item(ItemPedido item) {

    }

    public void add_funcionario(Funcionario func) {

    }

    public void add_cliente(ClienteJuridico cli) {

    }

    public void baixar_estoque() {

    }

}
