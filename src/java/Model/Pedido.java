package Model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.util.List;

public class Pedido {

	private int id;

	private double valor_total;

	private Date data;

	private List<ItemPedido> itensPedido;

	private ClienteJuridico cliente;

	private Funcionario funcionario;

	public void add_item(ItemPedido item) {

	}

	public void add_funcionario(Funcionario func) {

	}

	public void add_cliente(ClienteJuridico cli) {

	}

	public void baixar_estoque() {

	}

}
