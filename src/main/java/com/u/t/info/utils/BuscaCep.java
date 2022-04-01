package com.u.t.info.utils;

import com.u.t.info.view.TelaCadastro;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
public class BuscaCep implements ActionListener {

    String ruaStr;
    String bairroStr;
    String cidadeStr;
    String ufStr;

    private final TelaCadastro tela;

    /**
     * Construtor da classe
     * @param tela
     */
    public BuscaCep(TelaCadastro tela) {
        this.tela = tela;
    }

    /**
     * Pesquisar o cep ou mostrar mensagem de erro na tela
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String cep = tela.getCep().getText();
        int numCaracteres = cep.length();
        if (numCaracteres == 8) {

            buscarCep(cep);
        } else {
            JOptionPane.showConfirmDialog(null, "CEP INVÁLIDO", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
        }
    }

    /**
     * Metodo para buscar um cep valido
     * @param cep cep valido
     */
    public void buscarCep(String cep) {
        String json;

        try {

            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();

            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();

            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = new String[30];
            array = json.split("\n");

            if (array[1].equals("erro")) {
                JOptionPane.showConfirmDialog(null, "CEP INVÁLIDO", "ERRO", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                tela.getRua().setText("");
                tela.getBairro().setText("");
                tela.getCidade().setText("");
                tela.getUf().setText("");
            } else {
                ruaStr = array[7];
                bairroStr = array[15];
                cidadeStr = array[19];
                ufStr = array[23];

                tela.getRua().setText(ruaStr);
                tela.getBairro().setText(bairroStr);
                tela.getCidade().setText(cidadeStr);
                tela.getUf().setText(ufStr);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


