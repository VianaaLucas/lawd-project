/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author lucas
 */

public class PedidodeCompra {
    private int id;
    private Fornecedor fornecedor;
    private List<ItemDeCompra> item;
    private double total_pedido;
    private Date data_pedido;
    private String status;

    public List<ItemDeCompra> getItem() {
        return item;
    }

    public void setItem(List<ItemDeCompra> item) {
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
    }

    public double getTotal_pedido() {
        return total_pedido;
    }
    
    public int getId() {
        return id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

//    public double getTotal_pedido() {
//        double vtotal = 0;
//        for (Produto produto : this.produtos) {
//            vtotal += produto.getPreco_custo() * produto.getQtdcompra();
//        }
//        this.total_pedido = vtotal;
//        return total_pedido;
//    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

//    public void setProdutos(List<Produto> produtos) {
//        this.produtos = produtos;
//    }
//
//    public void setQuantidade(List quantidade) {
//        this.quantidade = quantidade;
//    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    
    
}
