package com.u.t.info.controller;

import com.u.t.info.src.Produto;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONProduto;
import com.u.t.info.view.TelaCadastroProduto;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/*
Integrantes do grupo:
Nome                            Matricula
Ágata Meireles Carvalho         202065001AC
Kleiton Ewerton de Oliveira     202065050AC
Luiz Miguel Batista Silva       202065060A
Nikolas Oliver Sales Genesio    202065072AC
 */

public class AtualizaProduto implements WindowListener {

    private final TelaCadastroProduto tela;
    private static final String CAMINHO = "arquivos/produtos.json";

    /**
     * Construtor da classe
     * @param tela tela de cadastro do produto
     */
    public AtualizaProduto(TelaCadastroProduto tela) {
        this.tela = tela;
    }

    /**
     * Resgatar a lista de produtos do arquivo
     * @param windowEvent
     */
    @Override
    public void windowOpened(WindowEvent windowEvent) {
        try {
            //janela é aberta
            String dados = Arquivo.lerArquivo(CAMINHO);
            if (!dados.isEmpty()) {
                List<Produto> produtos = JSONProduto.toProdutos(dados);
                tela.setListaProdutos(produtos);
            }
        } catch (FileNotFoundException ex) {
            //JOptionPane.showConfirmDialog(tela, "Não foi possível carregar os dados!");
            //aqui a lista esta vazia
        }
    }

    /**
     * Salvar a lista de produtos no arquivo
     * @param windowEvent
     */
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try {
            //janela é fechada
            List<Produto> produtos = tela.getListaProdutos();

            String toJSON = JSONProduto.toJSONProdutos(produtos);

            Arquivo.escreverArquivo(CAMINHO, toJSON);

        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(tela, "Não foi possível salvar os dados!");
        }
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
