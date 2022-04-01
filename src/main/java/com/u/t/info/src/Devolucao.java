/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u.t.info.src;

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
public class Devolucao {
    //atributos da devolucao
    private String nomeVendedor;
    private Produto produto;
    private int quantidade;
    private String Quebrado;

    /**
     * Construtor da classe
     * @param nomeVendedor Nome do vendedor
     * @param produto produto que vai ser devolvido
     * @param quantidade quantidade que vai ser devolvida
     * @param Quebrado produto esta quebrado
     */
    public Devolucao(String nomeVendedor, Produto produto, int quantidade, String Quebrado) {
        this.nomeVendedor = nomeVendedor;
        this.produto = produto;
        this.quantidade = quantidade;
        this.Quebrado = Quebrado;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getQuebrado() {
        return Quebrado;
    }

    public void setQuebrado(String Quebrado) {
        this.Quebrado = Quebrado;
    }
    
    
    
}
