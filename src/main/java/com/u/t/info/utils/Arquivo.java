package com.u.t.info.utils;

import java.io.*;
import java.util.Scanner;

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
public class Arquivo {

    /**
     * Metodo para ler um arquivo
     * @param caminho caminho do arquivo
     * @return conteudo do arquivo
     * @throws FileNotFoundException
     */
    public static String lerArquivo(String caminho) throws FileNotFoundException {

        StringBuilder conteudo = new StringBuilder();
        File arquivo = new File(caminho);

        Scanner leitor = new Scanner(arquivo);

        //varrendo conteudo do arquivo linha por linha
        while (leitor.hasNextLine()) {
            conteudo.append(leitor.nextLine()).append("\n");
        }

        return conteudo.toString();
    }

    /**
     * Metodo para a escrita do arquivo
     * @param caminho caminho do arquivo
     * @param conteudo conteudo a ser escrito no arquivo
     * @throws IOException
     */
    public static void escreverArquivo(String caminho, String conteudo) throws IOException {
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;

        File arquivo = new File(caminho);

        //Se o arquivo já existir, então abrir para concatenação, caso contrário criar novo arquivo
        fwArquivo = new FileWriter(arquivo, false);
        bwArquivo = new BufferedWriter(fwArquivo);

        // escrevendo String no arquivo e adicionando caracter para criar nova linha
        bwArquivo.write(conteudo);

        // fechando o arquivo
        bwArquivo.close();
        fwArquivo.close();
    }

}
