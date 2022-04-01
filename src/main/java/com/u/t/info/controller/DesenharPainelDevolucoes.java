package com.u.t.info.controller;

import com.u.t.info.view.TelaVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class DesenharPainelDevolucoes implements ActionListener{
    private TelaVendedor tela;

    /**
     * Construtor da classe
     * @param tela tela de vendedor
     */
    public DesenharPainelDevolucoes(TelaVendedor tela) {
        this.tela = tela;
    }

    /**
     * Painel de devolucoes aparecer na tela
     * @param arg0
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        tela.getCardLayout().show(tela.getPainelCards(),"3");
    }
    
    
}
