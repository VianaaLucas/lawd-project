package Control;

import Model.ItemDeCompra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lucas
 */
public class CarrinhoDeCompra {

    private Integer id;
    private List<ItemDeCompra> itens;
    private double total;

    public void addNovoItem(ItemDeCompra item) {
        if (this.itens == null) {
            this.itens = new ArrayList<ItemDeCompra>();
        }
        this.itens.add(item);
    }

    public void removerItem(ItemDeCompra itemRemove) {
        for (Iterator i = itens.iterator(); i.hasNext();) {
            ItemDeCompra item = (ItemDeCompra) i.next();
            if (item.getProduto().getId() == itemRemove.getProduto().getId()) {
                i.remove();
            }
        }
    }

    public double calculaTotal() {
        double vtotal = 0;
        for (ItemDeCompra item : this.itens) {
            vtotal += item.getTotal();
        }
        this.total = vtotal;
        return total;
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
    
    

}
