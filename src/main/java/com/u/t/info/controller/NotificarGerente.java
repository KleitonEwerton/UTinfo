package com.u.t.info.controller;

import com.u.t.info.src.Produto;
import com.u.t.info.tables.TableProdutos;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONProduto;
import com.u.t.info.view.TelaSupervisor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
 * @author agata
 */

/*
Ação que notifica o gerente caso o supervisor tenha notado produto com estoque baixo, é avisado em forma de notificação no momento em 
que gerente inicia seu login
*/
public class NotificarGerente implements ActionListener {

    
    //atributos
    TelaSupervisor tela;
    //caminho onde armazena o produto selecionado pelo supervisor
    private static final String CAMINHO = "arquivos/produtoEmFalta.json";

    /**
     * Construtor da classe
     * @param tela tela do supervisor
     */
    public NotificarGerente(TelaSupervisor tela) {
        this.tela = tela;
    }

    /**
     * Ação que realiza a leitura da linha da tabela selecionada e passa pro arquivo que sera usado para notificar o gerente
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //recebe o indice da linha selecionada da tabela de produtos na tela de supervisor
        int selectedIndex = tela.getTableProduto().getSelectedRow();

        
        //caso não tenha selecionado exibe uma mensagem
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione um produto!");
        } else {
            //modelo da tabela vindo da classe de TelaSupervisor
            TableProdutos modelo =  tela.getModelProduto();
            try {
                //inicializa um produto com os indices das colunas da tabela de indice selecionado
                Produto produtos = new Produto(modelo.getValueAt(selectedIndex, 0).toString(),
                        modelo.getValueAt(selectedIndex, 1).toString(), Double.parseDouble(modelo.getValueAt(selectedIndex, 2).toString()),
                        Double.parseDouble(modelo.getValueAt(selectedIndex, 3).toString()), modelo.getValueAt(selectedIndex, 4).toString(), 
                        modelo.getValueAt(selectedIndex, 5).toString(), modelo.getValueAt(selectedIndex, 6).toString(), 
                        Integer.parseInt(modelo.getValueAt(selectedIndex, 7).toString()), 
                        Integer.parseInt(modelo.getValueAt(selectedIndex, 8).toString()));
                
                String toJSON = JSONProduto.toJSONProduto(produtos);
                
                //escreve as informações do produto no arquivo
                Arquivo.escreverArquivo(CAMINHO, toJSON);
                JOptionPane.showMessageDialog(tela, "Gerente será notificado!");
            } catch (IOException ex) {
                JOptionPane.showConfirmDialog(tela, "Não foi possível salvar os dados!");
            }
        }
    }
}
