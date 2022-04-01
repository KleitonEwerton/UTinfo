package com.u.t.info.src;

import com.u.t.info.utils.JSONGerente;
import com.u.t.info.utils.JSONSupervisor;
import com.u.t.info.utils.JSONVendedor;

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
public abstract class Funcionario {

    //atributos
    private String nome;
    private String contato, tipo;
    private String cpf;
    private String senha;
    private String rua, numero,cidade, bairro, uf, cep;
    private double salario;

    /**
     * Construtor da classe
     * @param nome nome do funcionario
     * @param contato telefone do funcionario
     * @param tipo tipo do telefone do funcionario
     * @param cpf cpf do funcionario
     * @param senha senha do funcionario
     * @param rua rua do funcionario
     * @param numero numero da casa do funcionario
     * @param bairro bairro do funcionario
     * @param cidade cidade do funcionario
     * @param uf estado do funcionario
     * @param cep cep do funcionario
     * @param salario salario do funcionario
     */
    public Funcionario(String nome, String contato, String tipo, String cpf, String senha, String rua, String numero, String bairro, String cidade, String uf, String cep, double salario) {
        this.nome = nome;
        this.contato = contato;
        this.tipo = tipo;
        this.cpf = cpf;
        this.senha = senha;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public abstract double calculaPagamento();

    /**
     * Metodo responsavel por retornar a lista de funcionarios
     * @return
     */
    public static List<Funcionario> retornaListaFuncionarios()
    {
        List<Funcionario> funcionarios = new ArrayList<>();

        List<Gerente> gerenteList = new ArrayList<>();
        gerenteList = JSONGerente.lerGerentes();

        List<Supervisor> supervisorList = new ArrayList<>();
        supervisorList = JSONSupervisor.lerSupervisor();

        List<Vendedor> vendedorList = new ArrayList<>();
        vendedorList = JSONVendedor.lerVendedores();

        for (Gerente gerentes : gerenteList)
        {
            funcionarios.add(gerentes);
        }

        for(Supervisor supervisor: supervisorList)
        {
            funcionarios.add(supervisor);
        }

        for(Vendedor vendedor: vendedorList)
        {
            funcionarios.add(vendedor);
        }

        return funcionarios;
    }

} 
