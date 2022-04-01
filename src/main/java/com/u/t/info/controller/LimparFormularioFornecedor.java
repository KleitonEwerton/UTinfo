package com.u.t.info.controller;

import com.u.t.info.view.TelaCadastroFornecedor;

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
public class LimparFormularioFornecedor {

    private final TelaCadastroFornecedor tela;

    /**
     * Construtor da classe
     * @param tela tela de cadastro de fornecedor
     */
    public LimparFormularioFornecedor(TelaCadastroFornecedor tela) {
        this.tela = tela;
    }

    /**
     * Metodo para limpar as informações ja digitadas pelo usuario
     */
    public void LimparFormulario() {
        tela.getRazaoSocial().setText("");
        tela.getCnpj().setText("");
        tela.getRua().setText("");
        tela.getNumeroCasa().setText("");
        tela.getCidade().setText("");
        tela.getUf().setText("");
        tela.getCep().setText("");
        tela.getListaProdutos().setText("");
        tela.getBairro().setText("");
    }
}
