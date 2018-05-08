package Model;

import Model.DAO.PagamentoDAO;
import Model.ItemDeCompra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Pedido {

    private Integer id;
    private List<ItemDeCompra> itens;
    private double total;
    private int total_itens;
    private List<Pagamento> pagamentos;
    private double totalPago;
    private double troco;

    public void setId(Integer id) {
        this.id = id;
    }
    
    public double getTroco() {
        if (this.totalPago - this.total > 0){
            this.troco = Math.abs(this.totalPago - this.total);
        } else troco = 0.00;
        return troco;
    }
    
    public double getTotalPago() {
        return totalPago;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void addPagamento(Pagamento pagamento) {
        if (this.pagamentos == null) {
            this.pagamentos = new ArrayList<Pagamento>();
        }
        this.pagamentos.add(pagamento);
    }

    public void addNovoItem(ItemDeCompra item) {
        if (this.itens == null) {
            this.itens = new ArrayList<ItemDeCompra>();
        }
        this.itens.add(item);
        this.total_itens = total_itens + 1;
    }

    public void removerItem(ItemDeCompra itemRemove) {
        for (Iterator i = itens.iterator(); i.hasNext();) {
            ItemDeCompra item = (ItemDeCompra) i.next();
            if (item.getProduto().getId() == itemRemove.getProduto().getId()) {
                i.remove();
                this.total_itens = this.total_itens - 1;
            }
        }
    }

    public void removerPagamento(Pagamento pagamento) {
        for (Iterator i = pagamentos.iterator(); i.hasNext();) {
            Pagamento pag = (Pagamento) i.next();
            if (pag.getId() == pagamento.getId()) {
                i.remove();
                this.totalPago = this.totalPago - pag.getQuantia();
                PagamentoDAO pagDAO = new PagamentoDAO();
                pagDAO.cancelaPag(pag);
                
            }
        }
        getTroco();
    }

    public double calculaTotal() {
        double vtotal = 0;
        for (ItemDeCompra item : this.itens) {
            vtotal += item.getTotal();
        }
        this.total = vtotal;
        return total;
    }

    public double calculaTotalPago() {
        double vtotal = 0;
        for (Pagamento pagamento : this.pagamentos) {
            vtotal += pagamento.getQuantia();
        }
        this.totalPago = vtotal;
        return totalPago;
    }

    public double calculaRestante() {
        double restante = 0.00;
        restante = total - totalPago;
        if (restante < 0) {
            getTroco();
            return 0.00;
        }
        return restante;
    }

    public Integer getId() {
        return id;
    }

    public List<ItemDeCompra> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public int getTotal_itens() {
        return total_itens;
    }


}
