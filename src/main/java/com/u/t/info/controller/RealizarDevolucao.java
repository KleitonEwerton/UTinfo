package com.u.t.info.controller;

import com.u.t.info.src.Produto;
import com.u.t.info.utils.Arquivo;
import com.u.t.info.utils.JSONProduto;
import com.u.t.info.view.TelaCadastroProduto;
import com.u.t.info.view.TelaSupervisor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author agata
 */

/*
Classe usada pelo supervisor para rwalizar a devolução de um produto
*/
public class RealizarDevolucao implements ActionListener{
    
    //atributo
     private final TelaSupervisor tela;

    /**
     * Construtor da classe
     * @param tela tela do supervisor
     */
    public RealizarDevolucao(TelaSupervisor tela) {
        this.tela = tela;
    }

    /**
     * Evento de botão: remove o produto do arquivo e adiciona ele novamente com o estoque atualizado
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = String.valueOf(tela.getjComboBoxProdutos().getSelectedItem()); //item selecionado
        //como o item tem codigo e nome, pega somente o codigo
        String cod = str.substring(0, str.indexOf(' '));
        //tela de cadastro para atualizar a lista de produtos
        TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
        try {
            String dados = Arquivo.lerArquivo("arquivos/produtos.json"); //ler o arquivo
            if (!dados.isEmpty()) { //nao for vazio
                List<Produto> produtos = JSONProduto.toProdutos(dados);
                for(int i =0; i < produtos.size(); i++)
                {
                    if(cod.equals(produtos.get(i).getCodigo())) //faz a verificacao do codigo
                    {
                        String devolver = tela.getJtQuantidadeDevolucao().getText();
                        try {
                            int devolucao = Integer.parseInt(devolver);
                            //atualiza a quantidade de estque
                            produtos.get(i).setQtdeEstoque(devolucao+produtos.get(i).getQtdeEstoque());
                            //atualiza a lista de produtos
                            telaCadastroProduto.setListaProdutos(produtos);
                            //pega a lista atualizada
                            List<Produto> produtosAtualizados = telaCadastroProduto.getListaProdutos();
                            //apaga o que esta escrito no arquivo
                            PrintWriter printWriter = new PrintWriter("arquivos/produtos.json");
                            printWriter.print("");
                            printWriter.close();
                            String toJSON = JSONProduto.toJSONProdutos(produtosAtualizados);
                            //escreve com o estoque atualizado
                            Arquivo.escreverArquivo("arquivos/produtos.json", toJSON);
                            JOptionPane.showMessageDialog(tela, "Estoque Atualizado!");
                            tela.getJtQuantidadeDevolucao().setText("");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showConfirmDialog(null, "Verificar a quantidade! \nProibido uso de letras!", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            //JOptionPane.showConfirmDialog(tela, "Não foi possível carregar os dados!");
        } catch (IOException ex) {
            //JOptionPane.showConfirmDialog(tela, "Não foi possível salvar os dados!");
        }
        tela.repaint();
    }
    
}
