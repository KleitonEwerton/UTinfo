package com.u.t.info.controller;

import com.u.t.info.src.Cliente;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONCliente;
import com.u.t.info.view.TelaVendedor;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

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
public class AtualizaTabelaClientes implements WindowListener{

    private final TelaVendedor tela;
    private static final String CAMINHO = "arquivos/produtos.json";


    /**
     * Construtor da classe
     * @param tela tela do vendedor
     */
    public AtualizaTabelaClientes(TelaVendedor tela) {
        this.tela = tela;
    }


    /**
     * Resgatar a lista de clientes do arquivo
     * @param windowEvent
     */
    @Override
    public void windowOpened(WindowEvent windowEvent) {
        try {
            //janela é aberta
            String dados = Arquivo.lerArquivo(CAMINHO);
            if (!dados.isEmpty()) {
                List<Cliente> cliente = JSONCliente.toClientes(dados);
                tela.setClientes(cliente);
            }
        } catch (FileNotFoundException ex) {
            //JOptionPane.showConfirmDialog(tela, "Não foi possível carregar os dados!");
            //aqui a lista esta vazia
        }
    }

    /**
     * Salvar a lista de clientes no arquivo
     * @param windowEvent
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try {
            //janela é fechada
            List<Cliente> clientes = tela.getClientes();

            String toJSON = JSONCliente.toJSONClientes(clientes);

            Arquivo.escreverArquivo(CAMINHO, toJSON);

        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(tela, "Não foi possível salvar os dados!");
        }
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
    }
    
}
