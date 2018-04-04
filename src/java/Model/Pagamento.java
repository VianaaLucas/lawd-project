/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lucas
 */
public class Pagamento {

    private int id;
    private String tipo_pag;
    private double quantia;
    private int id_Pedido;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public void setTipo_pag(String tipo_pag) {
        this.tipo_pag = tipo_pag;
    }

    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }

    public String getTipo_pag() {
        return tipo_pag;
    }

    public double getQuantia() {
        return quantia;
    }

}
