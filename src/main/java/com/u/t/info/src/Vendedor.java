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
public class Vendedor extends Funcionario {
    
    private List<Venda> vendas;

    /**
     * Construtor da classe
     * @param vendas lista de vendas
     * @param nome nome do vendedor
     * @param contato telefone do vendedor
     * @param tipo tipo do telefone do vendedor
     * @param cpf cpf do vendedor
     * @param senha senha do vendedor
     * @param rua rua do vendedor
     * @param numero numero da casa do vendedor
     * @param bairro bairro do vendedor
     * @param cidade cidade do vendedor
     * @param uf estado do vendedor
     * @param cep cep do vendedor
     * @param salario salario do vendedor
     */
    public Vendedor(List<Venda> vendas, String nome, String contato, String tipo, String cpf, String senha, String rua, String numero, String bairro, String cidade, String uf, String cep, double salario) {
        super(nome, contato, tipo, cpf, senha, rua, numero, bairro, cidade, uf, cep, salario);
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
   

    @Override
    public double calculaPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
