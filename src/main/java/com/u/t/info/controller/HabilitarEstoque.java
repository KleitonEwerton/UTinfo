package com.u.t.info.controller;

import com.u.t.info.view.TelaSupervisor;
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
 * @author agata
 */

/*
Classe usada para Habilitar o Painel de Estoque da Tela de Supervisor
*/
public class HabilitarEstoque implements ActionListener{

    //atributo
    private TelaSupervisor tela;

    /**
     * Contrutor da classe
     * @param tela
     */
    public HabilitarEstoque(TelaSupervisor tela) {
        this.tela = tela;
    }

    /**
     * Função que reliza a ação de habilitar
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.getCardLayout().show(tela.getPainel(), "1");
    }
}
