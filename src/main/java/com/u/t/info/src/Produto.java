package com.u.t.info.src;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

public class Produto {

    //atributos da classe produto
    private String nome;
    private String codigo;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;
    private String descricao;
    private String modelo;
    private int qtdeEstoque;
    private int estoqueMinimo;

    // Construtor
    public Produto() {

    }

    /**
     * Construtor da classe
     * @param nome nome do produto
     * @param codigo codigo do produto
     * @param precoCompra preco de compra do produto
     * @param precoVenda preco de venda do produto
     * @param fornecedor fornecedor do produto
     * @param descricao descricao do produto
     * @param modelo modelo do produto
     * @param qtdeEstoque quantidade de estoque do produto
     * @param estoqueMinimo estoque minimo do produto
     */
    public Produto(String nome, String codigo, double precoCompra, double precoVenda, String fornecedor, String descricao, String modelo, int qtdeEstoque, int estoqueMinimo) {

        this.nome = nome;
        this.codigo = codigo;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.modelo = modelo;
        this.qtdeEstoque = qtdeEstoque;
        this.estoqueMinimo = estoqueMinimo;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    // funcao de desconto
    // Retorno: novo valor com desconto
    // param: valor da porcentagem. Ex.: 30.5 = 30.5%
    public double desconto(double porcentagem) {
        return this.precoVenda - (this.precoVenda * porcentagem / 100);
    }

    public void salvaProduto() {
        // TODO: salva esse produto no banco de dados
        System.out.println("Produto Salvo");
    }

}
