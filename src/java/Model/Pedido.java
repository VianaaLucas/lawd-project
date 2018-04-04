package Model;

import java.sql.Date;
import java.util.List;

public class Pedido {

    private int id;

    private double valor_total;

    private Date data;

    private List<ItemPedido> itensPedido;

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
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
