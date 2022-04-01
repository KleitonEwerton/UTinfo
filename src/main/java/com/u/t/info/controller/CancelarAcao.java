package com.u.t.info.controller;

import com.u.t.info.view.TelaCadastro;
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
 * @author KleitonEwerton
 */
public class CancelarAcao implements ActionListener{
    
    private final TelaCadastro tela;

    /**
     * Construtor da classe
     * @param tela tela de cadastro
     */
    public CancelarAcao(TelaCadastro tela) {
        this.tela = tela;
        
    }

    /**
     * Fechar a tela
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.dispose();
    }
    
}
