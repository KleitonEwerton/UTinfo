package com.u.t.info.controller;

import com.u.t.info.view.TelaCadastroCliente;
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
public class AbrirTelaCadastroCliente implements ActionListener{
    private TelaCadastroCliente tela;

    public AbrirTelaCadastroCliente() {
    }

    /**
     * Abrir tela de cadastro do cliente
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        tela = new TelaCadastroCliente();
        tela.desenha();
    }
}
