package com.u.t.info.controller;

import com.u.t.info.view.TelaCadastroFuncionario;

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
 * @author Nikolas
 */
public class LimparFormularioFuncionario {

    private final TelaCadastroFuncionario tela;

    /**
     * Construtor da classe
     * @param tela tela de cadastro do funcionario
     */
    public LimparFormularioFuncionario(TelaCadastroFuncionario tela) {
        this.tela = tela;
    }

    /**
     * Metodo para limpar as informações ja digitadas pelo usuario
     */
    public void LimparFormulario() {
        tela.getNome().setText("");
        tela.getTelefone().setText("");
        tela.getCpf().setText("");
        tela.getSenha1().setText("");
        tela.getSenha2().setText("");
        tela.getRua().setText("");
        tela.getNumeroCasa().setText("");
        tela.getCidade().setText("");
        tela.getUf().setText("");
        tela.getCep().setText("");
        tela.getBairro().setText("");
    }
}
