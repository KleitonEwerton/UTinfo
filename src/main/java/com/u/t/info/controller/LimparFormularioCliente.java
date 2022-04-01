package com.u.t.info.controller;

import com.u.t.info.view.TelaCadastroCliente;

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
public class LimparFormularioCliente {

    private final TelaCadastroCliente tela;

    /**
     * Construtor da classe
     * @param tela tela de cadastro de cliente
     */
    public LimparFormularioCliente(TelaCadastroCliente tela) {
        this.tela = tela;
    }

    /**
     * Metodo para limpar as informações ja digitadas pelo usuario
     */
    public void LimparFormulario() {
        tela.getNome().setText("");
        tela.getCpf().setText("");
        tela.getCep().setText("");
        tela.getRua().setText("");
        tela.getNumeroCasa().setText("");
        tela.getBairro().setText("");
        tela.getCidade().setText("");
        tela.getUf().setText("");
        tela.getTel1().setText("");
        tela.getTel().clearSelection();
        tela.repaint();
    }
}
