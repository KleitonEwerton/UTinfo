package com.u.t.info.src;

import java.util.ArrayList;
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
 * @author KleitonEwerton
 */

public class Gerente extends Funcionario{
    
    static public List<Produto> bdProdutos = new ArrayList<>();         //Simula Banco de dados, por enquanto
    static public List<Fornecedor> bdFornecedores = new ArrayList<>();  //Simula Banco de dados, por enquanto
    static public List<Supervisor> bdSupervisores = new ArrayList<>();  //Simula Banco de dados, por enquanto
    static public List<Vendedor> bdVendedores = new ArrayList<>();      //Simula Banco de dados, por enquanto


    /**
     * Construtor da classe
     * @param nome nome do gerente
     * @param contato telefone do gerente
     * @param tipo tipo do telefone do gerente
     * @param cpf cpf do gerente
     * @param senha senha do gerente
     * @param rua rua do gerente
     * @param numero numero da casa do gerente
     * @param bairro bairro do gerente
     * @param cidade cidade do gerente
     * @param uf estado do gerente
     * @param cep cep do gerente
     * @param salario salario do gerente
     */
    public Gerente(String nome, String contato, String tipo, String cpf, String senha, String rua, String numero, String bairro, String cidade, String uf, String cep, double salario){
        
        super(nome, contato, tipo, cpf, senha, rua, numero, bairro, cidade, uf, cep, salario);
        
    }
   
    public void emitirRelatorio(){
        
        //Escrita do relátorio em um arquivo da saída
    
    }

    @Override
    public double calculaPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
