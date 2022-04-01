/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.src;

import java.util.List;
/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

/**
 *
 * @author luiz
 */
public class Venda implements Vendas {
    //atributos
    private Vendedor vendedor;
    private Cliente cliente;
    private Produto produto;
    private double valor;

    /**
     * Construtor da classe
     * @param vendedor vendedor que esta realizando a compra
     * @param cliente cliente que esta comprando
     * @param produtos produto que esta sendo vendido
     * @param valor valor da compra
     */
    public Venda(Vendedor vendedor,Cliente cliente, Produto produtos, double valor) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.produto = produtos;
        this.valor = valor;
    }

    @Override
    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public Produto getProduto() {
        return produto;
    }

    @Override
    public void setProdutos(Produto produto) {
        this.produto = produto;
    }
    @Override
    public double getValor() {
        return valor;
    }
    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
