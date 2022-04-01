package com.u.t.info.controller;

import com.u.t.info.view.TelaCadastroProduto;

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
public class LimparFormularioProduto {
    private final TelaCadastroProduto tela;

    /**
     * Construtor da classe
     * @param tela tela de cadastro de produto
     */
    public LimparFormularioProduto(TelaCadastroProduto tela) {
        this.tela = tela;
    }

    /**
     * Metodo para limpar as informações ja digitadas pelo usuario
     */
    public void LimparFormulario() {
        tela.getNome().setText("");
        tela.getCodigo().setText("");
        tela.getCustoCompra().setText("");
        tela.getCustoVenda().setText("");
        tela.getDescricao().setText("");
        tela.getModelo().setText("");
        tela.getEstoqueInicial().setText("");
        tela.repaint();
    }
}
