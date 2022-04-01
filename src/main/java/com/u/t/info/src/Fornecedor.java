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
public class Fornecedor {

    //atributos
    private String razaoSocial;
    private String cnpj;
    
    private List<String> listaDeProdutos;
    private final String rua;
    private final String numero;
    private final String cidade;
    private final String uf;
    private final String cep;
    private final String bairro;

    /**
     * Construtor da classe
     * @param razaoSocial razão social do fornecedor
     * @param cnpj cnpj do fornecedor
     * @param listaDeProdutos lista de produtos que o fornecedor vende
     * @param rua rua do fornecedor
     * @param numero numero da sede do fornecedor
     * @param bairro bairro do fornecedor
     * @param cidade cidade do fornecedor
     * @param uf estado do fornecedor
     * @param cep cep do fornecedor
     */
    public Fornecedor(String razaoSocial, String cnpj,List<String> listaDeProdutos, String rua, String numero, String bairro, String cidade, String uf, String cep) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade=cidade;
        this.uf = uf;
        this.cep = cep;
        this.listaDeProdutos = listaDeProdutos;

    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<String> getListaDeProdutos() {
        return listaDeProdutos;
    }

    
    public void setListaDeProdutos(List<String> listaDeProdutos) {
        //Podemos usar também a estrutura List
        this.listaDeProdutos = listaDeProdutos;
        
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }
}
