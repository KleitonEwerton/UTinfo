package com.u.t.info.src;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

public class Cliente {
    //atributos
    private String nome;
    private String cpf;
    private String cidade;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String uf;
    private String telefone;
    private String tipo;

    /**
     * Construtor da classe
     * @param nome Nome do cliente
     * @param cpf cpf do cliente
     * @param cep cep do cliente
     * @param rua rua do cliente
     * @param numero numero da casa do cliente
     * @param bairro bairro do cliente
     * @param cidade cidade do cliente
     * @param uf estado do cliente
     * @param telefone telefone do cliente
     * @param tipo tipo de telefone do cliente
     */
    public Cliente(String nome, String cpf, String cep, String rua, String numero, String bairro, String cidade, String uf, String telefone, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.tipo = tipo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
