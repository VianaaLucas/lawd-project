/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates   
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author andre.albuquerque
 */
public class Desconto {

    private int id;
    private Categoria categoria;
    private Produto produto;
    private double percentualDeDesconto;
    private double precoComDesconto;
    private double valorObtido;

    // setters and getteres 

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public void setPrecoComDesconto(double precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }

    public Desconto() {

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPercentualDeDesconto() {
        return percentualDeDesconto;
    }

    public void setPercentualDeDesconto(double percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
    }

    public double getValorObtido() {
        return valorObtido;
    }

    public void setValorObtido(double valorObtido) {
        this.valorObtido = valorObtido;
    }

    public Desconto(double percentualDeDesconto) {
        this.percentualDeDesconto = percentualDeDesconto;
    }

    // contrutor de  calculo
    public double calcularDesconto(double valor) {
        return valorObtido = valor * getPercentualDeDesconto() / 100;
    }

    //retorna valor total com desconto
    public double getTotal(double valor) {
        return precoComDesconto = valor * (1 - getPercentualDeDesconto() / 100);
    }

}
